package Util;

import Logic.Syllable;

import java.util.ArrayList;

/**
 * This class creates an object, that can return a randomly selected hiragana
 * from a defined scope of syllables. It is not possible to have multiple
 * different randomizers at once.
 */
public class HiraganaRandomizer {

    /**
     * the one randomizer object
     */
    private static HiraganaRandomizer unique = null;

    /**
     * the list containing the current scope of syllables, which is used
     * to select one syllable at random
     */
    private static ArrayList<Syllable> hiragana = new ArrayList<>();

    /**
     * the syllable, which is returned if an error occurs
     */
    private Syllable errHiragana = new Syllable("err", "err");

    /**
     * The private constructor for the randomizer object. To get access to
     * an object of this class use
     * <Code>HiraganaRandomizer.getInstance()</Code>.
     */
    private HiraganaRandomizer() {
    }

    /**
     * Returns the one randomizer object, if the object is null, a new one
     * is created.
     * @return the one randomizer object
     */
    public static HiraganaRandomizer getInstance() {
        if (unique == null)
            return new HiraganaRandomizer();
        return unique;
    }

    /**
     * This method adds the five hiragana syllables matching a given consonant,
     * also called a 'row'
     * The given consonant is combined with each vowel and the corresponding
     * syllable is added to the randomizer list.
     * @param consonant the consonant of which the combined syllables are added
     */
    public void addRow(char consonant) {
        hiragana.add(HiraganaMatrix.getSyllable('a', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('i', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('u', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('e', consonant));
        hiragana.add(HiraganaMatrix.getSyllable('o', consonant));
    }

    /**
     * This method returns a randomly selected hiragana syllable from the list
     * of syllables
     * @return a from the internal list randomly selected hiragana syllable
     */
    public Syllable getRandomSyllable() {
        if (hiragana.isEmpty()) {
            return errHiragana;
        } else {
            Syllable randomHiragana = null;
            do {
                randomHiragana = hiragana.get((int) (Math.random() * hiragana.size()));
            } while (randomHiragana == null);
            return randomHiragana;
        }
    }

    public void clear() {
        hiragana.clear();
    }

    public void addAll() {
        addRow('a');
        addRow('k');
        addRow('s');
        addRow('t');
        addRow('n');
        addRow('h');
        addRow('m');
        addRow('y');
        addRow('r');
        addRow('w');
        hiragana.add(HiraganaMatrix.getSyllable('n'));
    }
}
