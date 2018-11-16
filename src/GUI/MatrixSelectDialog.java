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

    private int matrixHeight;
    private int matrixWidth;

    /**
     * the matrix containing the checkboxes, each of these checkboxes represents
     * the object at the same position in <Code>matrix</Code>
     */
    private Checkbox[][] checkboxMatrix;

    /**
     * TODO change this
     */
    private static final boolean IS_HORIZONTAL = true;

    /**
     * Creates a new modal JDialog with a matrix of objects specified by the
     * type of this class. Each object can then be selected by the user and the
     * current state of the selection can be requested.
     * @param parent the parent frame of this modal dialog
     * @param matrix the matrix which is used to fill the panel with information
     * @param hasColumnSelector if this is true a checkbox for each column is
     *                          created that allows the user to select a column
     *                          at once
     * @param hasRowSelector if this is true a checkbox for each row is created
     *                       that allows the user to select a row at once
     */
    public MatrixSelectDialog(Frame parent, E[][] matrix, boolean hasColumnSelector,  boolean hasRowSelector) {
        super(parent, true);
        setResizable(false);

        /**
         * changes look and feel to the windows standard
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        this.matrix = matrix;
        if (matrix == null) {
            return;
        }

        matrixHeight = hasColumnSelector ? matrix.length + 1 : matrix.length;
        matrixWidth = hasColumnSelector ? matrix[0].length + 1 : matrix[0].length;

        checkboxMatrix = new Checkbox[matrixHeight][matrixWidth];

        font = getFont();

        if (IS_HORIZONTAL) {
            setLayout(new GridLayout(matrixWidth, matrixHeight));
        } else {
            setLayout(new GridLayout(matrixHeight, matrixWidth));
        }
        /**
         * displays the matrix and creates the corresponding checkboxes
         */
        for (int i = 0; i < matrixHeight; i++)
            for (int j = 0; j < matrixWidth; j++) {
                checkboxMatrix[i][j] = new Checkbox();
            }

        for (int j = 0; j < matrixWidth; j++) {
            for (int i = 0; i < matrixHeight; i++) {
                JPanel panel = new JPanel();
                if (matrix[i][j] != null) {
                    panel.setLayout(new BorderLayout());
                    panel.add(checkboxMatrix[i][j], BorderLayout.NORTH);
                    JLabel checkBoxLabel = new JLabel(getCheckboxLabelString(matrix[i][j]));
                    checkBoxLabel.setFont(font.deriveFont(FONTSIZE));
                    panel.add(checkBoxLabel, BorderLayout.CENTER);
                }
                add(panel);
            }
        }

        pack();
        setVisible(true);
    }


    public Boolean[][] getBooleanMatrix() {
        Boolean[][] b = new Boolean[matrixHeight][matrixWidth];
        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                b[i][j] = checkboxMatrix[i][j].getState();
            }
        }
        return b;
    }

    public boolean getStateOfCheckBox(int i, int j) {
        if (i < 0 || i > matrixHeight || j < 0 || j > matrixWidth) {
            throw new IndexOutOfBoundsException("getStateOfCheckBox()");
        }
        return checkboxMatrix[i][j].getState();
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
