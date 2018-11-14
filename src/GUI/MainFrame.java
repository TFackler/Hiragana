package GUI;

import Util.HiraganaRandomizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


/**
 * The main window of this application.
 */
public class MainFrame extends JFrame {

    /**
     * the panel which contains the random single hiragana writing exercise
     */
    private RandomSingleHiraganaPanel randomSingleHiraganaPanel;


    /**
     * Creates a new main frame window
     */
    public MainFrame() {
        /**
         * changes the look and feel to the windows standard
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        /**
         * preferences for the frame are being made
         */
        setSize(800,400);

        /**
         * creates the panel which contains the random single hiragana writing exercise
         */
        randomSingleHiraganaPanel = RandomSingleHiraganaPanel.getInstance(this);
        add(randomSingleHiraganaPanel);


        setVisible(true);
    }

    public static void main(String[]args){
        new MainFrame();
    }
    
}


