package Util;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by TFackler on 06.11.2018.
 */

public abstract class FontUtil {

    private static Font hiraganaFont = null;

    public static Font getHiraganaFont(ClassLoader classLoader) {
        if (hiraganaFont == null) {
            try {
                File fontFile = new File(classLoader.getResource("res/nukamiso__beta08.ttf").getFile());
                hiraganaFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            } catch (IOException | FontFormatException e) {
                System.err.println("Error creating Font!");
                //Handle exception
            }
        }
        return hiraganaFont;
    }

    public static void setFontAntiAliasingOn() {
        System.setProperty("swing.useSystemFontSettings", "on");
        System.setProperty("swing.useSystemAAFontSettings", "on");
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
    }
}
