package Util;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * A abstract class containing methods for managing Fonts
 */
public abstract class FontUtil {

    // the default font for the hiragana strings
    private static Font hiraganaFont = null;

    /**
     * Returns the default font for the hiragana strings.
     * @param classLoader the classloader used for extracting the font from the res folder
     * @return the font used for hiragana strings
     */
    public static Font getHiraganaFont(ClassLoader classLoader) {
        if (hiraganaFont == null) {
            try {
                // File fontFile = new File(classLoader.getResource("res/nukamiso__beta08.ttf").getFile());
                File fontFile = new File(classLoader.getResource("res/UDDigiKyokashoN-R.ttc").getFile());
                hiraganaFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            } catch (IOException | FontFormatException e) {
                System.err.println("Error creating Font!");
            }
        }
        return hiraganaFont;
    }

    /**
     * Activates FontAntiAliasing.
     * (Makes the text look more focused.)
     */
    public static void setFontAntiAliasingOn() {
        System.setProperty("swing.useSystemFontSettings", "on");
        System.setProperty("swing.useSystemAAFontSettings", "on");
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
    }
}
