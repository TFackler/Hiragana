package Util;

import java.util.ArrayList;

public class HiraganaRandomizer {

    private ArrayList<String> hiragana = new ArrayList<String>();

    public HiraganaRandomizer() {

    }

    public void addRow(char consonant) {
        hiragana.add(HiraganaMatrix.getSyllable('a', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('i', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('u', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('e', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('o', consonant));
    }

    public String getRandomSyllable() {
        return hiragana.get((int) (Math.random() * hiragana.size()));
    }


}
