package Util;

import Logic.Syllable;

import java.util.ArrayList;

/**
 * This class creates an object, that can return a randomly selected syllable
 * from a defined scope of syllables. It is not possible to have multiple
 * different randomizers at once.
 */
public class SyllableRandomizer {

    /**
     * the one randomizer object
     */
    private static SyllableRandomizer unique = null;

    /**
     * the list containing the current scope of syllables, which is used
     * to select one syllable at random
     */
    private static ArrayList<Syllable> syllable = new ArrayList<>();

    /**
     * the syllable, which is returned if an error occurs
     */
    private Syllable errHiragana = new Syllable("err", "err", "err");

    /**
     * The private constructor for the randomizer object. To get access to
     * an object of this class use
     * <Code>HiraganaRandomizer.getInstance()</Code>.
     */
    private SyllableRandomizer() {
        addAll();
    }

    /**
     * Returns the one randomizer object, if the object is null, a new one
     * is created.
     * @return the one randomizer object
     */
    public static SyllableRandomizer getInstance() {
        if (unique == null)
            return new SyllableRandomizer();
        return unique;
    }

    /**
     * This method adds the five syllable syllables matching a given consonant,
     * also called a 'row'
     * The given consonant is combined with each vowel and the corresponding
     * syllable is added to the randomizer list.
     * @param consonant the consonant of which the combined syllables are added
     */
    public void addRow(char consonant) {
        syllable.add(SyllableMatrix.getSyllable('a', consonant));
        syllable.add(SyllableMatrix.getSyllable('i', consonant));
        syllable.add(SyllableMatrix.getSyllable('u', consonant));
        syllable.add(SyllableMatrix.getSyllable('e', consonant));
        syllable.add(SyllableMatrix.getSyllable('o', consonant));
    }

    /**
     * This method returns a randomly selected syllable syllable from the list
     * of syllables
     * @return a from the internal list randomly selected syllable syllable
     */
    public Syllable getRandomSyllable() {
        if (syllable.isEmpty()) {
            return errHiragana;
        } else {
            Syllable randomHiragana = null;
            do {
                randomHiragana = syllable.get((int) (Math.random() * syllable.size()));
            } while (randomHiragana == null);
            return randomHiragana;
        }
    }

    /**
     * Clears the randomizer pool.
     */
    public void clear() {
        syllable.clear();
    }

    /**
     * Adds all of the Hiragana Syllables.
     */
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
        addRow('g');
        addRow('z');
        addRow('d');
        addRow('b');
        addRow('p');
    }

    /**
     * Changes the randomize pool using a boolean matrix.
     * @param booleanMatrix the boolean matrix of the same size as the
     *                      hiraganamatrix
     */
    public void setRandomizePoolByBooleanMatrix(boolean[][] booleanMatrix) {
        clear();
        int matrixHeight = booleanMatrix.length;
        int matrixWidth = booleanMatrix[0].length;

        Syllable[][] syllableMatrix = SyllableMatrix.getMatrix();

        if (matrixHeight != syllableMatrix.length ||
                matrixWidth != syllableMatrix[0].length) {
            throw new IndexOutOfBoundsException("Boolean matrix differs from " +
                    "Hiragana Matrix Size");
        }

        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (booleanMatrix[i][j]) {
                    syllable.add(syllableMatrix[i][j]);
                }
            }
        }
    }
}
