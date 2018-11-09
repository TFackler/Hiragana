package Logic;

import Util.HiraganaRandomizer;

public class SyllableHistory extends History<Syllable> {

    private HiraganaRandomizer randomizer = HiraganaRandomizer.getInstance();

    public SyllableHistory(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public Syllable createNew() {
        return randomizer.getRandomSyllable();
    }
}
