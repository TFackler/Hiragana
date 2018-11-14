package GUI;

import Logic.*;
import Util.FontUtil;
import Util.HiraganaMatrix;
import Util.HiraganaRandomizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * A class for displaying the random hiragana writing exercise in a JPanel
 */
public class RandomSingleHiraganaPanel extends JPanel{

    /**
     *
     */
    private static RandomSingleHiraganaPanel unique = null;

    private boolean isHidden = false;

    private HiraganaRandomizer randomizer;

    private JPanel characterPanel;
    private JLabel romanjiLabel;
    private JLabel hiraganaLabel;

    private JFrame parent;

    private SyllableHistory hiraganaHistory = new SyllableHistory(100);

    private JPanel buttonPanel;

    private RandomSingleHiraganaPanel(JFrame parent) {
        this.parent = parent;

        setLayout(new BorderLayout());

        randomizer = HiraganaRandomizer.getInstance();
        randomizer.addRow('a');

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
        buttonPanel.add(bNext);

        JButton bSelect = new JButton("open selection");
        bSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HiraganaSelectDialog(parent, false, false);
            }
        });
        buttonPanel.add(bSelect);

                add(buttonPanel, BorderLayout.SOUTH);
    }

    public static RandomSingleHiraganaPanel getInstance(JFrame parent) {
        if (unique == null)
            return new RandomSingleHiraganaPanel(parent);
        return unique;
    }
}
