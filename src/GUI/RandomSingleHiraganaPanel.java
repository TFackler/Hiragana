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
 * A class for displaying the random hiragana writing exercise in a JPanel
 */
public class RandomSingleHiraganaPanel extends JPanel{

    /**
     * the one random hiragana panel that can exist at once
     */
    private static RandomSingleHiraganaPanel unique = null;

    /**
     * shows wether the hiragana symbol is hidden
     */
    private boolean isHidden = false;

    /**
     * the object, that randomizes the order of appearing hiragana
     */
    private SyllableRandomizer randomizer;

    /**
     * the parent JFrame in which this panel is embedded
     */
    private JFrame parent;

    /**
     * the panel in which the hiragana and romanji characters are embedded in
     */
    private JPanel characterPanel;

    /**
     * the labels in which the hiragana and romanji are written
     */
    private JLabel romanjiLabel;
    private JLabel hiraganaLabel;

    /**
     * the history used for keeping track of the syllable order
     */
    private SyllableHistory hiraganaHistory = new SyllableHistory(100);

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
    private RandomSingleHiraganaPanel(JFrame parent) {

        this.parent = parent;

        setLayout(new BorderLayout());

        randomizer = SyllableRandomizer.getInstance();
        randomizer.addAll();

        /**
         * initializing the part of the window responsible for displaying the romanji and hiragana variant of
         * the syllable
         */
        characterPanel = new JPanel();
        characterPanel.setLayout(new GridLayout(1,2));

        romanjiLabel = new JLabel("", SwingConstants.CENTER);
        romanjiLabel.setFont(new Font(null, Font.PLAIN, 150));
        characterPanel.add(romanjiLabel);

        hiraganaLabel = new JLabel("", SwingConstants.CENTER);
        // hiraganaLabel.setFont(FontUtil.getHiraganaFont(getClass().getClassLoader()).deriveFont(200f));
        hiraganaLabel.setFont(new Font(null, Font.PLAIN, 150));
        characterPanel.add(hiraganaLabel);

        add(characterPanel, BorderLayout.CENTER);

        /**
         * initializing the part of the window responsible for interacting with the program, this is due to change
         */
        buttonPanel = new JPanel();

        JButton bBack = new JButton("<-");
        bBack.addActionListener(e -> {
            hiraganaHistory.previous();
            Syllable s = hiraganaHistory.getCurrent();
            romanjiLabel.setText(s.getRomanji());
            hiraganaLabel.setText(s.getHiragana());
        });
        buttonPanel.add(bBack);

        JButton bToggleHide = new JButton("hide");
        bToggleHide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isHidden) {
                    isHidden = false;
                    bToggleHide.setText("hide");
                    hiraganaLabel.setForeground(getForeground());
                } else {
                    isHidden = true;
                    bToggleHide.setText("show");
                    hiraganaLabel.setForeground(hiraganaLabel.getBackground());
                }
            }
        });
        buttonPanel.add(bToggleHide);


        JButton bNext = new JButton("->");
        bNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hiraganaHistory.next();
                Syllable s = hiraganaHistory.getCurrent();
                romanjiLabel.setText(s.getRomanji());
                hiraganaLabel.setText(s.getHiragana());
            }
        });
        buttonPanel.add(bNext);

        // selection

        JButton bSelect = new JButton("open selection");
        bSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HiraganaSelectDialog(parent, false, false, checked);
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
         * TODO get Focus to actual JFrame and not one component
         */
        bNext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    hiraganaHistory.next();
                    Syllable s = hiraganaHistory.getCurrent();
                    romanjiLabel.setText(s.getRomanji());
                    hiraganaLabel.setText(s.getHiragana());
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
    public static RandomSingleHiraganaPanel getInstance(JFrame parent) {
        if (unique == null)
            return new RandomSingleHiraganaPanel(parent);
        return unique;
    }
}
