package GUI;

import Logic.Syllable;
import Util.FontUtil;
import Util.HiraganaMatrix;
import Util.HiraganaRandomizer;

import java.awt.*;

/**
 * a Dialog for selecting the hiragana from which the random hiragana are selected
 */
public class HiraganaSelectDialog extends MatrixSelectDialog<Syllable> {

    /**
     * Creates a new dialog for selecting hiragana
     * @param parent the parent frame of this dialog
     * @param hasColumnSelector indicates whether a checkbox to select a complete
     *                          column at once is created
     * @param hasRowSelector indicates whether a checkbox to select a complete
     *                          row at once is created
     */
    public HiraganaSelectDialog(Frame parent, boolean hasColumnSelector, boolean hasRowSelector, boolean[][] checked) {
        super(parent, HiraganaMatrix.getMatrix(), hasColumnSelector, hasRowSelector, checked);
    }

    /**
     * Returns a string representation for a syllable which is used in the
     * matrix.
     * @param object the syllable object which is used to create the String
     *               representation
     * @return the formatted string representation of the syllable
     */
    @Override
    public String getCheckboxLabelString(Syllable object) {
        return "<html><p \"style:align=center\">" + object.getHiragana() + "<br>" + object.getRomanji() + "</p></html>";
    }

    /**
     * Returns the font used for displaying the text in the checkbox labels
     * @return the font used for displaying the text in the checkbox labels
     */
    @Override
    public Font getFont() {
        return FontUtil.getHiraganaFont(getClass().getClassLoader());
    }
}
