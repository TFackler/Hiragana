package Logic;

/**
 * This class represents a hiragana syllables. It contains information about the
 * hiragana and the romanji representation of a syllable.
 */
public class Syllable {

    // the string representation of the romanji syllable
    private final String romanji;

    // the string representation of the hiragana syllable
    private final String hiragana;

    /**
     * Creates a new Syllable using the string of the romanji and the hiragana
     * representation of the syllable.
     * @param romanji the string of the romanji representation
     * @param hiragana the string of the hiragana representation
     */
    public Syllable(String romanji, String hiragana) {
        this.romanji = romanji;
        this.hiragana = hiragana;
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
}
