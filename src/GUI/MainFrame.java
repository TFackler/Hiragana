package GUI;

import Util.HiraganaRandomizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Tamino on 01.11.2018.
 */


public class MainFrame extends JFrame {

    private JLabel hiraganaText;


    private HiraganaRandomizer randomizer;

    public MainFrame() {
        setSize(400,400);
        setLayout(new BorderLayout());

        hiraganaText = new JLabel("", SwingConstants.CENTER);
        hiraganaText.setFont(new Font(null, Font.PLAIN, 100));
        add(hiraganaText, BorderLayout.CENTER);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,2));
        add(p, BorderLayout.SOUTH);

        JButton bBack = new JButton("<-");
        //bBack.addActionListener();
        p.add(bBack);

        JButton bNext = new JButton("->");

        bNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hiraganaText.setText(randomizer.getRandomSyllable());
            }
        });
        p.add(bNext);

        randomizer = new HiraganaRandomizer();
        randomizer.addRow('a');
        randomizer.addRow('k');
        randomizer.addRow('s');

        bNext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                test();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                test();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                test();
            }
        });
        bNext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    hiraganaText.setText(randomizer.getRandomSyllable());
                }
            }
        });

        setVisible(true);
    }


    private void test() {
        Color c = new Color(200,255,200);
        if (hiraganaText.getBackground().getBlue() == c.getBlue() &&
                hiraganaText.getBackground().getRed() == c.getRed() &&
                hiraganaText.getBackground().getGreen() == c.getGreen()) {
            hiraganaText.setBackground(getBackground());
        } else {
            hiraganaText.setBackground(new Color(200,255,200));
        }
    }
    public static void main(String[]args){
        new MainFrame();
    }
    
}


