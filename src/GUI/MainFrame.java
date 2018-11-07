package GUI;

import Util.HiraganaRandomizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Created by Tamino on 01.11.2018.
 */


public class MainFrame extends JFrame {

    private JLabel hiraganaText;

    private RandomSingleHiraganaPanelFontCompare randomSingleHiraganaPanel;


    public MainFrame() {
        setSize(800,400);
        randomSingleHiraganaPanel = RandomSingleHiraganaPanelFontCompare.getInstance();
        add(randomSingleHiraganaPanel);


        setVisible(true);
    }


    public static void main(String[]args){
        new MainFrame();
    }
    
}


