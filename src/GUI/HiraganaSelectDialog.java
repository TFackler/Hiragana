package GUI;

import Logic.Syllable;

import java.awt.*;

public class HiraganaSelectDialog extends MatrixSelectDialog<Syllable> {

    public HiraganaSelectDialog(Frame parent, Syllable[][] matrix, boolean hasColumnSelector, boolean hasRowSelector) {
        super(parent, matrix, hasColumnSelector, hasRowSelector);
    }

    @Override
    public String getCheckboxLabelString(Syllable object) {
        return object.getHiragana() + "\n" + object.getRomanji();
    }
}
