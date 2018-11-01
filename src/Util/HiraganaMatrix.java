package Util;

/**
 * Created by Tamino on 01.11.2018.
 */
public abstract class HiraganaMatrix {

    private static String[][] hiraganaMatrix = {
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
    /*
    private static String[] aRow = {"a", "i", "u", "e", "o"};
    private static String[] kRow = {"ka", "ki", "ku", "ke", "ko"};
    private static String[] sRow = {"sa", "shi", "su", "se", "so"};
    private static String[] tRow = {"ta", "chi", "tsu", "te", "to"};
    private static String[] nRow = {"na", "ni", "nu", "ne", "no"};
    private static String[] hRow = {"ha", "hi", "fu", "he", "ho"};
    private static String[] mRow = {"ma", "mi", "mu", "me", "mo"};
    private static String[] yRow = {"ya", null, "yu", null, "yo"};
    private static String[] rRow = {"ra", "ri", "ru", "re", "ro"};
    private static String[] wRow = {"wa", "wi", null, "we", "wo"};
    private static String nSyllable = "n";
    private static String[] gRow = {"ga", "gi", "gu", "ge", "go"};
    private static String[] zRow = {"za", "ji", "zu", "ze", "zo"};
    private static String[] dRow = {"da", "ji", "zu", "de", "do"};
    private static String[] bRow = {"ba", "bi", "bu", "be", "bo"};
    private static String[] pRow = {"pa", "pi", "pu", "pe", "po"};
    */

    public static String getSyllable(char vowel, char consonant) {
        int rowPosition;
        switch (vowel) {
            case 'a':
                rowPosition = 0;
                break;
            case 'i':
                rowPosition = 1;
                break;
            case 'e':
                rowPosition = 2;
                break;
            case 'u':
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

        return hiraganaMatrix[rowPosition][columnPosition];
    }

    public static String getSyllable(char consonant) {
        if (consonant != 'n') {
            return null;
        }
        return hiraganaMatrix[10][0];
    }






}
