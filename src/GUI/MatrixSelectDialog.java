package GUI;

import javax.swing.*;
import java.awt.*;

public abstract class MatrixSelectDialog<E> extends JDialog {

    private E[][] matrix;
    private Checkbox[][] checkboxMatrix;

    public MatrixSelectDialog(Frame parent, E[][] matrix, boolean hasColumnSelector,  boolean hasRowSelector) {
        super(parent, true);
        this.matrix = matrix;

        if (matrix == null) {
            return;
        }

        int matrixHeight = hasColumnSelector ? matrix.length + 1 : matrix.length;
        int matrixWidth = hasColumnSelector ? matrix[0].length + 1 : matrix[0].length;

        checkboxMatrix = new Checkbox[matrixHeight][matrixWidth];

        setLayout(new GridLayout(matrixWidth, matrixHeight));

        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                JPanel panel = new JPanel();
                if (matrix[i][j] != null) {
                    checkboxMatrix[i][j] = new Checkbox(getCheckboxLabelString(matrix[i][j]));
                    panel.add(checkboxMatrix[i][j]);
                }
                add(panel);
            }
        }

        setVisible(true);


    }

    public abstract String getCheckboxLabelString(E object);


}
