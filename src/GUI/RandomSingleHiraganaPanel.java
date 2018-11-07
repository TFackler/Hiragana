package GUI;

import Logic.Hiragana;
import Logic.Syllable;
import Util.FontUtil;
import Util.HiraganaRandomizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by TFackler on 05.11.2018.
 */
public class RandomSingleHiraganaPanel extends JPanel{

    private static RandomSingleHiraganaPanel unique = null;

    private boolean isHidden = false;

    private ArrayList<Syllable> hiraganaHistory = new ArrayList<Syllable>(100);
    private int historyPos = 0;

    private HiraganaRandomizer randomizer;

    private JPanel characterPanel;
    private JLabel romanjiLabel;
    private JLabel hiraganaLabel;

    private JPanel buttonPanel;

    private RandomSingleHiraganaPanel() {
        setLayout(new BorderLayout());

        randomizer = HiraganaRandomizer.getInstance();
        randomizer.addRow('a');
        randomizer.addRow('k');
        randomizer.addRow('s');
        randomizer.addRow('t');
        randomizer.addRow('n');

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
        hiraganaLabel.setFont(FontUtil.getHiraganaFont(getClass().getClassLoader()).deriveFont(200f));
        characterPanel.add(hiraganaLabel);

        add(characterPanel, BorderLayout.CENTER);

        /**
         * initializing the part of the window responsible for interacting with the program, this is due to change
         */
        buttonPanel = new JPanel();

        JButton bBack = new JButton("<-");
        bBack.addActionListener(e -> {

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

    public void addHiraganaToHistory(Syllable syllable) {
        if (hiraganaHistory.size() == 100) {
            hiraganaHistory.remove(0);
        } else {
            historyPos++;
        }
        hiraganaHistory.add(syllable);
    }

    public void nextHiragana() {
        if (hiraganaHistory.size() == historyPos + 1) {
            
            randomizer.getRandomSyllable();
            // add syllable
            // set text
        }
    }

    public void prevHiragana() {
        if (historyPos != 0) {
            historyPos--;
            romanjiLabel.setText(hiraganaHistory.get(historyPos).getRomanji());
            hiraganaLabel.setText(hiraganaHistory.get(historyPos).getHiragana());
        }

    }



}
