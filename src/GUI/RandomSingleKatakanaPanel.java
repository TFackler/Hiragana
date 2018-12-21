package GUI;

import Logic.*;
import Util.SyllableMatrix;
import Util.SyllableRandomizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A class for displaying the random katakana writing exercise in a JPanel
 */
public class RandomSingleKatakanaPanel extends JPanel{

    /**
     * the one random katakana panel that can exist at once
     */
    private static RandomSingleKatakanaPanel unique = null;

    /**
     * shows wether the katakana symbol is hidden
     */
    private boolean isHidden = false;

    /**
     * the object, that randomizes the order of appearing katakana
     */
    private SyllableRandomizer randomizer;

    /**
     * the parent JFrame in which this panel is embedded
     */
    private JFrame parent;

    /**
     * the panel in which the katakana and romanji characters are embedded in
     */
    private JPanel characterPanel;

    /**
     * the labels in which the katakana and romanji are written
     */
    private JLabel romanjiLabel;
    private JLabel katakanaLabel;

    /**
     * the history used for keeping track of the syllable order
     */
    private SyllableHistory katakanaHistory = new SyllableHistory(100);

    /**
     * the panel in which the buttons are located
     */
    private JPanel buttonPanel;

    private boolean[][] checked = MatrixSelectDialog.getBooleanMatrixFromMatrix(SyllableMatrix.getMatrix());

    /**
     * Constructor, that creates a new panel for displaying the random hirgana
     * exercise
     * @param parent the JFrame this panel is embedded in
     */
    private RandomSingleKatakanaPanel(JFrame parent) {

        this.parent = parent;

        setLayout(new BorderLayout());

        randomizer = SyllableRandomizer.getInstance();
        randomizer.addAll();

        /**
         * initializing the part of the window responsible for displaying the romanji and katakana variant of
         * the syllable
         */
        characterPanel = new JPanel();
        characterPanel.setLayout(new GridLayout(1,2));

        romanjiLabel = new JLabel("", SwingConstants.CENTER);
        romanjiLabel.setFont(new Font(null, Font.PLAIN, 150));
        characterPanel.add(romanjiLabel);

        katakanaLabel = new JLabel("", SwingConstants.CENTER);
        katakanaLabel.setFont(new Font(null, Font.PLAIN, 150));
        characterPanel.add(katakanaLabel);

        add(characterPanel, BorderLayout.CENTER);

        /**
         * initializing the part of the window responsible for interacting with the program, this is due to change
         */
        buttonPanel = new JPanel();

        JButton bBack = new JButton("<-");
        bBack.addActionListener(e -> {
            katakanaHistory.previous();
            Syllable s = katakanaHistory.getCurrent();
            romanjiLabel.setText(s.getRomanji());
            katakanaLabel.setText(s.getKatakana());
        });
        buttonPanel.add(bBack);

        JButton bToggleHide = new JButton("hide");
        bToggleHide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isHidden) {
                    isHidden = false;
                    bToggleHide.setText("hide");
                    katakanaLabel.setForeground(getForeground());
                } else {
                    isHidden = true;
                    bToggleHide.setText("show");
                    katakanaLabel.setForeground(katakanaLabel.getBackground());
                }
            }
        });
        buttonPanel.add(bToggleHide);


        JButton bNext = new JButton("->");
        bNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                katakanaHistory.next();
                Syllable s = katakanaHistory.getCurrent();
                romanjiLabel.setText(s.getRomanji());
                katakanaLabel.setText(s.getKatakana());
            }
        });
        buttonPanel.add(bNext);

        // selection

        JButton bSelect = new JButton("open selection");
        bSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KatakanaSelectDialog(parent, false, false, checked);
                randomizer.setRandomizePoolByBooleanMatrix(checked);
/**
 for (int i = 0; i < boolMatrix.length; i++) {
 for (int j = 0; j < boolMatrix[0].length; j++) {
 System.out.print("\t" + boolMatrix[i][j]);
 }
 System.out.println();
 }
 System.out.print("---");
 */
            }
        });
        buttonPanel.add(bSelect);

        JButton bNavigateBack = new JButton("Back to Menu");
        bNavigateBack.addActionListener(e -> GUIManager.getInstance().navigateTo(PANELS.NAVIGATION));
        buttonPanel.add(bNavigateBack);

        /**
         * Adding Keylisteners for extended UX
         */
        bNext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    katakanaHistory.next();
                    Syllable s = katakanaHistory.getCurrent();
                    romanjiLabel.setText(s.getRomanji());
                    katakanaLabel.setText(s.getKatakana());
                }
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * The method that creates the one unique instance of this class
     * @param parent the JFrame the panel is embedded in
     * @return the created or existent unique instance of this class
     */
    public static RandomSingleKatakanaPanel getInstance(JFrame parent) {
        if (unique == null)
            return new RandomSingleKatakanaPanel(parent);
        return unique;
    }
}
