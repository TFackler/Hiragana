package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * A class for making a dialog for selecting entries from a matrix
 * @param <E> the type of object saved in the matrix
 */
public abstract class MatrixSelectDialog<E> extends JDialog {

    /**
     * the size of the font displaying the checkbox label
     */
    private static final float FONTSIZE = 25f;

    /**
     * the font used to display the text of the checkbox labels
     */
    private Font font;

    /**
     * the matrix containing the elements which can be selected
     */
    private E[][] matrix;

    /**
     * the matrix containing the checkboxes, each of these checkboxes represents
     * the object at the same position in <Code>matrix</Code>
     */
    private Checkbox[][] checkboxMatrix;

    /**
     * TODO change this
     */
    private static final boolean IS_HORIZONTAL = true;

    public MatrixSelectDialog(Frame parent, E[][] matrix, boolean hasColumnSelector,  boolean hasRowSelector) {
        super(parent, true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        this.matrix = matrix;
        font = getFont();

        if (matrix == null) {
            return;
        }

        int matrixHeight = hasColumnSelector ? matrix.length + 1 : matrix.length;
        int matrixWidth = hasColumnSelector ? matrix[0].length + 1 : matrix[0].length;

        checkboxMatrix = new Checkbox[matrixHeight][matrixWidth];

        if (IS_HORIZONTAL) {
            setLayout(new GridLayout(matrixWidth, matrixHeight));
        } else {
            setLayout(new GridLayout(matrixHeight, matrixWidth));
        }


        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                JPanel panel = new JPanel();
                if (matrix[i][j] != null) {
                    checkboxMatrix[i][j] = new Checkbox();
                    JLabel checkBoxLabel = new JLabel(getCheckboxLabelString(matrix[i][j]));
                    checkBoxLabel.setFont(font.deriveFont(FONTSIZE));
                    panel.setLayout(new GridLayout(2,1));
                    panel.add(checkboxMatrix[i][j]);
                    panel.add(checkBoxLabel);
                }
                add(panel);
            }
        }

        pack();
        setVisible(true);
    }

    /**
     * Returns the representation of an object saved in the matrix as a String.
     * This String is then used in the checkbox label of that object.
     * @param object the object of which the representation should be made
     * @return the String used in the checkbox label for that object
     */
    public abstract String getCheckboxLabelString(E object);

    /**
     * returns the font which is used for displaying text in the checkbox labels
     * @return the font which is used for displaying text in the checkbox labels
     */
    public abstract Font getFont();


}
