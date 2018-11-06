package Util;

import Logic.Syllable;

import java.util.ArrayList;

public class HiraganaRandomizer {

    private static HiraganaRandomizer unique = null;

    private ArrayList<Syllable> hiragana = new ArrayList<Syllable>();

    private HiraganaRandomizer() {

    }

    public static HiraganaRandomizer getInstance() {
        if (unique == null)
            return new HiraganaRandomizer();
        return unique;
    }

    public void addRow(char consonant) {
        hiragana.add(HiraganaMatrix.getSyllable('a', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('i', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('u', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('e', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('o', consonant));
    }

    public Syllable getRandomSyllable() {
        return hiragana.get((int) (Math.random() * hiragana.size()));
    }
}
