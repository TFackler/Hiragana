package GUI;

import java.awt.*;

@Deprecated
public class IntegerMatrix extends MatrixSelectDialog<Integer> {


    public IntegerMatrix(Frame parent, Integer[][] matrix, boolean hasColumnSelector, boolean hasRowSelector, boolean[][] checked) {
        super(parent, matrix, hasColumnSelector, hasRowSelector, checked);
    }

    @Override
    public String getCheckboxLabelString(Integer object) {
        return object.toString();
    }

    @Override
    public Font getFont() {
        return new Font(null, Font.PLAIN, 30);
    }
}
