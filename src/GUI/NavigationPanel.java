package GUI;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {

    public NavigationPanel(GUIManager guiManager) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("NavigationScreen");
        add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        JButton goToKatakanaButton = new JButton("Katakana");
        goToKatakanaButton.addActionListener(e -> guiManager.switchToRandomSingleKatakanaPanel());
        buttonPanel.add(goToKatakanaButton);

        JButton goToHiraganaButton = new JButton("Hiragana");
        goToHiraganaButton.addActionListener(e -> guiManager.switchToRandomSingleHiraganaPanel());
        buttonPanel.add(goToHiraganaButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
