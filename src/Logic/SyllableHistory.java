package Logic;

import Util.HiraganaRandomizer;

/**
 * A history of Syllable objects.
 */
public class SyllableHistory extends History<Syllable> {

    // the randomizer used for creating new syllables
    private HiraganaRandomizer randomizer = HiraganaRandomizer.getInstance();

    /**
     * Creates a new history for syllables
     * @param maxCapacity the maximum capacity of the history
     */
    public SyllableHistory(int maxCapacity) {
        super(maxCapacity);
    }

    /**
     * This method returns a random syllable created by the hiragana randomizer
     * @return a random syllable object
     */
    @Override
    public Syllable createNew() {
        return randomizer.getRandomSyllable();
    }
}
