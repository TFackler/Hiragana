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

            {       new Syllable("sa", "あ"),
                    new Syllable("shi", "い"),
                    new Syllable("su", "う"),
                    new Syllable("se", "え"),
                    new Syllable("so", "お"),},

            {       new Syllable("ta", "あ"),
                    new Syllable("chi", "い"),
                    new Syllable("tsu", "う"),
                    new Syllable("te", "え"),
                    new Syllable("to", "お"),},

            {       new Syllable("na", "あ"),
                    new Syllable("ni", "い"),
                    new Syllable("nu", "う"),
                    new Syllable("ne", "え"),
                    new Syllable("no", "お"),}
    };

    /**
    private static String[][] hiraganaRomanjiMatrix = {
            {"a", "i", "u", "e", "o"},
            {"ka", "ki", "ku", "ke", "ko"},
            {"sa", "shi", "su", "se", "so"},
            {"ta", "chi", "tsu", "te", "to"},
            {"na", "ni", "nu", "ne", "no"},
            {"ha", "hi", "fu", "he", "ho"},
            {"ma", "mi", "mu", "me", "mo"},
            {"ya", null, "yu", null, "yo"},
            {"ra", "ri", "ru", "re", "ro"},
            {"wa", "wi", null, "we", "wo"},
            {"n", null, null, null, null},
            {"ga", "gi", "gu", "ge", "go"},
            {"za", "ji", "zu", "ze", "zo"},
            {"da", "ji", "zu", "de", "do"},
            {"ba", "bi", "bu", "be", "bo"},
            {"pa", "pi", "pu", "pe", "po"}
    };

    private static String[][] hiraganaMatrix = {
            {"あ", "い", "う", "え", "お"},
            {"ka", "ki", "ku", "ke", "ko"},
            {"sa", "shi", "su", "se", "so"},
            {"ta", "chi", "tsu", "te", "to"},
            {"na", "ni", "nu", "ne", "no"},
            {"ha", "hi", "fu", "he", "ho"},
            {"ma", "mi", "mu", "me", "mo"},
            {"ya", null, "yu", null, "yo"},
            {"ra", "ri", "ru", "re", "ro"},
            {"wa", "wi", null, "we", "wo"},
            {"n", null, null, null, null},
            {"ga", "gi", "gu", "ge", "go"},
            {"za", "ji", "zu", "ze", "zo"},
            {"da", "ji", "zu", "de", "do"},
            {"ba", "bi", "bu", "be", "bo"},
            {"pa", "pi", "pu", "pe", "po"}
    };
    */

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
}
