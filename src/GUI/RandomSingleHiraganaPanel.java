package GUI;

import Logic.Syllable;
import Util.FontUtil;
import Util.HiraganaRandomizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by TFackler on 05.11.2018.
 */
public class RandomSingleHiraganaPanel extends JPanel{

    private static RandomSingleHiraganaPanel unique = null;

    private boolean isHidden = false;

    private HiraganaRandomizer randomizer;

    private JPanel characterPanel;
    private JLabel romanjiLabel;
    private JLabel hiraganaLabel;

    private JPanel buttonPanel;

    private RandomSingleHiraganaPanel() {
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
        //bBack.addActionListener();
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
                Syllable s = randomizer.getRandomSyllable();
                romanjiLabel.setText(s.getRomanji());
                hiraganaLabel.setText(s.getHiragana());
            }
        });
        bNext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Syllable s = randomizer.getRandomSyllable();
                    romanjiLabel.setText(s.getRomanji());
                    hiraganaLabel.setText(s.getHiragana());
                }
            }
        });
        buttonPanel.add(bNext);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static RandomSingleHiraganaPanel getInstance() {
        if (unique == null)
            return new RandomSingleHiraganaPanel();
        return unique;
    }


}
