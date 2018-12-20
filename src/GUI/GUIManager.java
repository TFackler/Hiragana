package GUI;

import javax.swing.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class GUIManager {

    private static RandomSingleKatakanaPanel randomSingleKatakanaPanel;

    private static RandomSingleHiraganaPanel randomSingleHiraganaPanel;

    private static NavigationPanel navigationPanel;



    private static JFrame mainFrame;

    private GUIManager() {
        initFrame();

        randomSingleHiraganaPanel = RandomSingleHiraganaPanel.getInstance(mainFrame);

        randomSingleKatakanaPanel = RandomSingleKatakanaPanel.getInstance(mainFrame);

        navigationPanel = new NavigationPanel(this);

        switchToNavigationPanel();

        mainFrame.setVisible(true);
    }

    public void switchToRandomSingleKatakanaPanel() {
        removeAll();
        mainFrame.setContentPane(randomSingleKatakanaPanel);
        mainFrame.invalidate();
        mainFrame.validate();
    }

    public void switchToRandomSingleHiraganaPanel() {
        removeAll();
        mainFrame.setContentPane(randomSingleHiraganaPanel);
        mainFrame.invalidate();
        mainFrame.validate();
    }

    public void switchToNavigationPanel() {
        removeAll();
        mainFrame.setContentPane(navigationPanel);
        mainFrame.invalidate();
        mainFrame.validate();
    }

    public static void main(String[] args) {
        new GUIManager();
    }

    private void initFrame() {
        mainFrame = new JFrame();
        /**
         * changes the look and feel to the windows standard
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        /**
         * preferences for the frame are being made
         */
        mainFrame.setSize(800,400);

        mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void removeAll() {
        mainFrame.remove(randomSingleHiraganaPanel);
        mainFrame.remove(randomSingleKatakanaPanel);
        mainFrame.remove(navigationPanel);
    }
}
