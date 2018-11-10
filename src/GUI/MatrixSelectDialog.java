package GUI;

import javax.swing.*;
import java.awt.*;

public abstract class MatrixSelectDialog<E> extends JDialog {

    private E[][] matrix;

    public MatrixSelectDialog(Frame parent, E[][] matrix, boolean hasColumnSelector,  boolean hasRowSelector) {
        super(parent, true);
        this.matrix = matrix;

        if (matrix == null) {
            return;
        }

        int matrixWidth = hasColumnSelector ? matrix.length : matrix.length + 1;
        int matrixHeight = hasColumnSelector ? matrix[0].length : matrix[0].length + 1;

        setLayout(new GridLayout(matrixWidth, matrixHeight));

        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {

            }
        }
    }
}
