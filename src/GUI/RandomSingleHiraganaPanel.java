package GUI;

/**
 * Created by Tamino on 05.11.2018.
 */
public class RandomSingleHiraganaPanel {
    private static RandomSingleHiraganaPanel ourInstance = new RandomSingleHiraganaPanel();

    public static RandomSingleHiraganaPanel getInstance() {
        return ourInstance;
    }

    private RandomSingleHiraganaPanel() {
    }
}
