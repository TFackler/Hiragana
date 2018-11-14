package Util;

import Logic.Syllable;

/**
 * @class This abstract class is the access point to the hiragana alphabet.
 * Created by TFackler on 01.11.2018.
 */
public abstract class HiraganaMatrix {

    private static Syllable[][] hiraganaSyllableMatrix = {
            {       new Syllable("a", "あ"),
                    new Syllable("i", "い"),
                    new Syllable("u", "う"),
                    new Syllable("e", "え"),
                    new Syllable("o", "お"),},

            {       new Syllable("ka", "か"),
                    new Syllable("ki", "き"),
                    new Syllable("ku", "く"),
                    new Syllable("ke", "け"),
                    new Syllable("ko", "こ"),},

            {       new Syllable("sa", "さ"),
                    new Syllable("shi", "し"),
                    new Syllable("su", "す"),
                    new Syllable("se", "せ"),
                    new Syllable("so", "そ"),},

            {       new Syllable("ta", "た"),
                    new Syllable("chi", "ち"),
                    new Syllable("tsu", "つ"),
                    new Syllable("te", "て"),
                    new Syllable("to", "と"),},

            {       new Syllable("na", "な"),
                    new Syllable("ni", "に"),
                    new Syllable("nu", "ぬ"),
                    new Syllable("ne", "ね"),
                    new Syllable("no", "の"),},

            {       new Syllable("ha", "は"),
                    new Syllable("hi", "ひ"),
                    new Syllable("fu", "ふ"),
                    new Syllable("he", "へ"),
                    new Syllable("ho", "ほ"),},

            {       new Syllable("ma", "ま"),
                    new Syllable("mi", "み"),
                    new Syllable("mu", "む"),
                    new Syllable("me", "め"),
                    new Syllable("mo", "も"),},

            {       new Syllable("ya", "や"),
                    null,
                    new Syllable("yu", "ゆ"),
                    null,
                    new Syllable("yo", "よ"),},

            {       new Syllable("ra", "ら"),
                    new Syllable("ri", "り"),
                    new Syllable("ru", "る"),
                    new Syllable("re", "れ"),
                    new Syllable("ro", "ろ"),},

            {       new Syllable("wa", "わ"),
                    null,
                    null,
                    null,
                    new Syllable("wo", "を"),},

            {       new Syllable("n", "ん"),
                    null,
                    null,
                    null,
                    null,}


    };


    /**
     * Returns the specified romanji syllable as a String. Note: Every syllable consists
     * of one vowel and one consonant.
     * @param vowel the vowel of the syllable
     * @param consonant the consonant of the syllable
     * @return the specified syllable as a String.
     */
    public static Syllable getSyllable(char vowel, char consonant) {
        int rowPosition;
        switch (vowel) {
            case 'a':
                rowPosition = 0;
                break;
            case 'i':
                rowPosition = 1;
                break;
            case 'u':
                rowPosition = 2;
                break;
            case 'e':
                rowPosition = 3;
                break;
            case 'o':
                rowPosition = 4;
                break;
            default:
                rowPosition = -1;
        }
        int columnPosition;
        switch (consonant) {
            case 'a':
                columnPosition = 0;
                break;
            case 'k':
                columnPosition = 1;
                break;
            case 's':
                columnPosition = 2;
                break;
            case 't':
                columnPosition = 3;
                break;
            case 'n':
                columnPosition = 4;
                break;
            case 'h':
                columnPosition = 5;
                break;
            case 'm':
                columnPosition = 6;
                break;
            case 'y':
                columnPosition = 7;
                break;
            case 'r':
                columnPosition = 8;
                break;
            case 'w':
                columnPosition = 9;
                break;
            case 'g':
                columnPosition = 11;
                break;
            case 'z':
                columnPosition = 12;
                break;
            case 'd':
                columnPosition = 13;
                break;
            case 'b':
                columnPosition = 14;
                break;
            case 'p':
                columnPosition = 15;
                break;
            default:
                columnPosition = -1;
        }

        if (rowPosition == -1 || columnPosition == -1) {
            return null;
        }

        return hiraganaSyllableMatrix[columnPosition][rowPosition];
    }


    /**
     * Returns the specified special romanji syllable as a String.
     * @param consonant the special syllable identifier
     * @return the specified syllable as a String.
     */
    public static Syllable getSyllable(char consonant) {
        if (consonant == 'n') {
            return hiraganaSyllableMatrix[10][0];
        }
        return null;
    }

    /**
     * Returns the one existent hiragana matrix, which is a matrix consisting
     * of all the hiragana syllables.
     * The objects in the matrix are <Code>Syllable</Code>-objects.
     * @return the matrix containing syllables which represent every hiragana
     * syllable
     */
    public static Syllable[][] getMatrix() {
        return hiraganaSyllableMatrix;
    }
}
