package Logic;

import java.awt.image.BufferedImage;

public class Hiragana {

    private String romanjiSyllable;
    private String hiraganaPicPath;
    private String hiraganaInstuctionPicPath;

    /**
     * Creates a new hiragana
     * @param romanjiSyllable
     * @param hiraganaPicPath
     * @param hiraganaInstuctionPicPath
     */
    public Hiragana(String romanjiSyllable, String hiraganaPicPath, String hiraganaInstuctionPicPath) {
        this.romanjiSyllable = romanjiSyllable;
        this.hiraganaPicPath = hiraganaPicPath;
        this.hiraganaInstuctionPicPath = hiraganaInstuctionPicPath;
    }

    /**
     * Returns the syllable of the hiragana this object represents in romanji
     * @return the romanji syllable of the hiragana
     */
    public String getRomanjiSyllable() {
        return romanjiSyllable;
    }

    /**
     * Returns a square image of the hiragana this object represents
     * @param size the wanted pixel count of the square image
     * @return the image of the hiragana
     */
    public BufferedImage getHiraganaImage(int size) {
        return null;
    }



}
