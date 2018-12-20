package Util;

import Logic.Syllable;

/**
 * @class This abstract class is the access point to the hiragana alphabet.
 * Created by TFackler on 01.11.2018.
 */
public abstract class SyllableMatrix {

    private static Syllable[][] hiraganaSyllableMatrix = {
            {       new Syllable("a", "あ", "ア"),
                    new Syllable("i", "い", "イ"),
                    new Syllable("u", "う", "ウ"),
                    new Syllable("e", "え", "エ"),
                    new Syllable("o", "お", "オ"),},

            {       new Syllable("ka", "か", "カ"),
                    new Syllable("ki", "き", "キ"),
                    new Syllable("ku", "く", "ク"),
                    new Syllable("ke", "け", "ケ"),
                    new Syllable("ko", "こ", "コ"),},

            {       new Syllable("sa", "さ", "サ"),
                    new Syllable("shi", "し", "シ"),
                    new Syllable("su", "す", "ス"),
                    new Syllable("se", "せ", "セ"),
                    new Syllable("so", "そ", "ソ"),},

            {       new Syllable("ta", "た", "タ"),
                    new Syllable("chi", "ち", "チ"),
                    new Syllable("tsu", "つ", "ツ"),
                    new Syllable("te", "て", "テ"),
                    new Syllable("to", "と", "ト"),},

            {       new Syllable("na", "な", "ナ"),
                    new Syllable("ni", "に", "ニ"),
                    new Syllable("nu", "ぬ", "ヌ"),
                    new Syllable("ne", "ね", "ネ"),
                    new Syllable("no", "の", "ノ"),},

            {       new Syllable("ha", "は", "ハ"),
                    new Syllable("hi", "ひ", "ヒ"),
                    new Syllable("fu", "ふ", "フ"),
                    new Syllable("he", "へ", "ヘ"),
                    new Syllable("ho", "ほ", "ホ"),},

            {       new Syllable("ma", "ま", "マ"),
                    new Syllable("mi", "み", "ミ"),
                    new Syllable("mu", "む", "ム"),
                    new Syllable("me", "め", "メ"),
                    new Syllable("mo", "も", "モ"),},

            {       new Syllable("ya", "や", "ヤ"),
                    null,
                    new Syllable("yu", "ゆ", "ユ"),
                    null,
                    new Syllable("yo", "よ", "ヨ"),},

            {       new Syllable("ra", "ら", "ラ"),
                    new Syllable("ri", "り", "リ"),
                    new Syllable("ru", "る", "ル"),
                    new Syllable("re", "れ", "レ"),
                    new Syllable("ro", "ろ", "ロ"),},

            {       new Syllable("wa", "わ", "ワ"),
                    null,
                    null,
                    null,
                    new Syllable("wo", "を", "ヲ"),},

            {       new Syllable("n", "ん", "ン"),
                    null,
                    null,
                    null,
                    null,},

            {       new Syllable("ga","が", "ガ"),
                    new Syllable("gi","ぎ", "ギ"),
                    new Syllable("gu","ぐ", "グ"),
                    new Syllable("ge","げ", "ゲ"),
                    new Syllable("go","ご", "ゴ"),},

            {       new Syllable("za","ざ", "ザ"),
                    new Syllable("ji","じ", "ジ"),
                    new Syllable("zu","ず", "ズ"),
                    new Syllable("ze","ぜ", "ゼ"),
                    new Syllable("zo","ぞ", "ゾ"),},

            {       new Syllable("da","だ", "ダ"),
                    new Syllable("ji","ぢ", "ヂ"),
                    new Syllable("zu","づ", "ヅ"),
                    new Syllable("de","で", "デ"),
                    new Syllable("do","ど", "ド"),},

            {       new Syllable("ba","ば", "バ"),
                    new Syllable("bi","び", "ビ"),
                    new Syllable("bu","ぶ", "ブ"),
                    new Syllable("be","べ", "ベ"),
                    new Syllable("bo","ぼ", "ボ"),},

            {       new Syllable("pa","ぱ", "パ"),
                    new Syllable("pi","ぴ", "ピ"),
                    new Syllable("pu","ぷ", "プ"),
                    new Syllable("pe","ぺ", "ペ"),
                    new Syllable("po","ぽ", "ポ"),}
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
