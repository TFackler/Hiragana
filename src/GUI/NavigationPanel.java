package GUI;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {

    private GUIManager guiManager;

    public NavigationPanel(GUIManager guiManager) {
        setLayout(new BorderLayout());

        this.guiManager = guiManager;

        JLabel label = new JLabel("NavigationScreen");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        JButton goToKatakanaButton = new JButton("Katakana");
        goToKatakanaButton.addActionListener(e -> guiManager.navigateTo(PANELS.RANDOM_SINGLE_KATAKANA));
        buttonPanel.add(goToKatakanaButton);

        JButton goToHiraganaButton = new JButton("Hiragana");
        goToHiraganaButton.addActionListener(e -> guiManager.navigateTo(PANELS.RANDOM_SINGLE_HIRAGANA));
        buttonPanel.add(goToHiraganaButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
