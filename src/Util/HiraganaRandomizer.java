package Util;

import Logic.Syllable;

import java.util.ArrayList;

public class HiraganaRandomizer {

    private static HiraganaRandomizer unique = null;

    private static ArrayList<Syllable> hiragana = new ArrayList<>();

    private Syllable errHiragana = new Syllable("err", "err");

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
        if (hiragana.isEmpty()) {
            return errHiragana;
        } else {
            return hiragana.get((int) (Math.random() * hiragana.size()));
        }
    }
}
