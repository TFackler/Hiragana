package GUI;

import javax.swing.*;
import java.awt.*;

public abstract class MatrixSelectDialog<E> extends JDialog {

    private static final float FONTSIZE = 25f;
    private Font font;
    private E[][] matrix;
    private Checkbox[][] checkboxMatrix;

    private static final boolean IS_HORIZONTAL = false;



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
        JPanel panelMatrix[][] = new JPanel[matrixHeight][matrixWidth];

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
                    JPanel checkBoxPanel = new JPanel();
                    checkBoxPanel.setLayout(new BorderLayout());
                    if (IS_HORIZONTAL) {
                        panel.setLayout(new GridLayout(1,2));
                    } else {
                        panel.setLayout(new GridLayout(2, 1));
                    }
                    checkBoxPanel.add(checkboxMatrix[i][j], BorderLayout.CENTER);
                    panel.add(checkBoxPanel);
                    panel.add(checkBoxLabel);
                }
                if (!IS_HORIZONTAL) {
                    add(panel);
                } else {
                    panelMatrix[i][j] = panel;
                }
            }
        }

        if (IS_HORIZONTAL) {
            for (int i = 0; i < matrixWidth; i++) {
                for (int j = 0; j < matrixHeight; j++) {
                    add(panelMatrix[j][i]);
                }
            }
        }

        pack();
        setVisible(true);
    }

    public abstract String getCheckboxLabelString(E object);

    public abstract Font getFont();


}
