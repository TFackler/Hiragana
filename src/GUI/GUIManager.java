package GUI;

import javax.swing.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class GUIManager {

    private static RandomSingleKatakanaPanel randomSingleKatakanaPanel;

    private static RandomSingleHiraganaPanel randomSingleHiraganaPanel;

    private static JPanel currentPanel;

    private static NavigationPanel navigationPanel;

    private static JFrame mainFrame;

    private static GUIManager unique = null;


    private GUIManager() {
        initFrame();

        randomSingleHiraganaPanel = RandomSingleHiraganaPanel.getInstance(mainFrame);

        randomSingleKatakanaPanel = RandomSingleKatakanaPanel.getInstance(mainFrame);

        navigationPanel = new NavigationPanel(this);

        currentPanel = navigationPanel;


        mainFrame.add(currentPanel);
        mainFrame.setVisible(true);
    }

    public static GUIManager getInstance() {
        if (unique == null)
            unique = new GUIManager();
        return unique;
    }

    public void navigateTo(PANELS destination) {
        mainFrame.remove(currentPanel);

        switch (destination) {
            case NAVIGATION:
                currentPanel = navigationPanel;
                break;
            case RANDOM_SINGLE_HIRAGANA:
                currentPanel = randomSingleHiraganaPanel;
                break;
            case RANDOM_SINGLE_KATAKANA:
                currentPanel = randomSingleKatakanaPanel;
                break;
            default:
                throw new UnhandledRunTimException("Not a panel to navigate to!");
        }

        mainFrame.add(currentPanel);
        mainFrame.invalidate();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public static void main(String[] args) {
        GUIManager guiManager = getInstance();
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
}
