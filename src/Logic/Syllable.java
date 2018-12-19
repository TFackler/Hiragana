package Logic;

/**
 * This class represents a hiragana syllable. It contains information about the
 * hiragana and the romanji representation of a syllable.
 */
public class Syllable {

    // the string representation of the romanji syllable
    private final String romanji;

    // the string representation of the hiragana syllable
    private final String hiragana;

    // the string representation of the katakana syllable
    private final String katakana;

    /**
     * Creates a new Syllable using the string of the romanji, the hiragana
     * and the katakana representation of the syllable.
     * @param romanji the string of the romanji representation
     * @param hiragana the string of the hiragana representation
     * @param katakana the string of the katakana representation
     */
    public Syllable(String romanji, String hiragana, String katakana) {
        this.romanji = romanji;
        this.hiragana = hiragana;
        this.katakana = katakana;
    }

    /**
     * Gets the syllables romanji representation as a String.
     * @return the romanji representation of the syllable as a String
     */
    public String getRomanji() {
        return romanji;
    }

    /**
     * Gets the syllables hiragana representation as a String.
     * @return the hiragana representation of the syllable as a String
     */
    public String getHiragana() {
        return hiragana;
    }

    /**
     * Gets the syllables katakana representation as a String.
     * @return the katakana representation of the syllable as a String
     */
    public String getKatakana() { return katakana; }
}
