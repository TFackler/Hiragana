package Logic;

/**
 * Created by Tamino on 05.11.2018.
 */
public class Syllable {

    private final String romanji;
    private final String hiragana;

    public Syllable(String romanji, String hiragana) {
        this.romanji = romanji;
        this.hiragana = hiragana;
    }

    public String getRomanji() {
        return romanji;
    }

    public String getHiragana() {
        return hiragana;
    }
}
