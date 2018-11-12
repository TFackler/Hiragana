package GUI;

import Logic.Syllable;
import Util.FontUtil;

import java.awt.*;

public class HiraganaSelectDialog extends MatrixSelectDialog<Syllable> {

    public HiraganaSelectDialog(Frame parent, Syllable[][] matrix, boolean hasColumnSelector, boolean hasRowSelector) {
        super(parent, matrix, hasColumnSelector, hasRowSelector);
    }

    @Override
    public String getCheckboxLabelString(Syllable object) {
        return "<html><p \"style:align=center\">" + object.getHiragana() + " (" + object.getRomanji() + ")</p></html>";
    }

    @Override
    public Font getFont() {
        return FontUtil.getHiraganaFont(getClass().getClassLoader());
    }
}
