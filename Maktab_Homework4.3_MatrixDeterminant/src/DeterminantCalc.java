import java.math.BigDecimal;


class DeterminantCalc {

    private double[][] matrixArray;
    private int sign = 1;


    public int getSign() {
        return sign;
    }


    public double[][] getMatrixArray() {
        return matrixArray;
    }


    DeterminantCalc(Matrix matrix) {
        this.matrixArray = matrix.getValueArray();
    }


    public BigDecimal determinant() {

        BigDecimal deter;
        if (isUpperTriangular() || isLowerTriangular())
            deter = multiplyDiameter().multiply(BigDecimal.valueOf(sign));

        else {
            makeTriangular();
            deter = multiplyDiameter().multiply(BigDecimal.valueOf(sign));

        }
        return deter;
    }


    /*  receives a matrixArray and make it triangular using allowed operations
        on columns and rows
    */
    public void makeTriangular() {

        for (int j = 0; j < matrixArray.length; j++) {
            sortCol(j);
            for (int i = matrixArray.length - 1; i > j; i--) {
                if (matrixArray[i][j] == 0)
                    continue;

                double x = matrixArray[i][j];
                double y = matrixArray[i - 1][j];
                multiplyRow(i, (-y / x));
                addRow(i, i - 1);
                multiplyRow(i, (-x / y));
            }
        }
    }


    public boolean isUpperTriangular() {

        if (matrixArray.length < 2)
            return false;

        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrixArray[i][j] != 0)
                    return false;

            }

        }
        return true;
    }


    public boolean isLowerTriangular() {

        if (matrixArray.length < 2)
            return false;

        for (int j = 0; j < matrixArray.length; j++) {
            for (int i = 0; j > i; i++) {
                if (matrixArray[i][j] != 0)
                    return false;

            }

        }
        return true;
    }


    public BigDecimal multiplyDiameter() {

        BigDecimal result = BigDecimal.ONE;
        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray.length; j++) {
                if (i == j)
                    result = result.multiply(BigDecimal.valueOf(matrixArray[i][j]));

            }

        }
        return result;
    }


    // when matrixArray[i][j] = 0 it makes it's value non-zero
    public void makeNonZero(int rowPos, int colPos) {

        int len = matrixArray.length;

        outer:
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (matrixArray[i][j] != 0) {
                    if (i == rowPos) { // found "!= 0" in it's own row, so cols must be added
                        addCol(colPos, j);
                        break outer;

                    }
                    if (j == colPos) { // found "!= 0" in it's own col, so rows must be added
                        addRow(rowPos, i);
                        break outer;
                    }
                }
            }
        }
    }


    //add row1 to row2 and stores int row1
    public void addRow(int row1, int row2) {

        for (int j = 0; j < matrixArray.length; j++)
            matrixArray[row1][j] += matrixArray[row2][j];
    }


    //adds col1 to col2
    public void addCol(int col1, int col2) {

        for (int i = 0; i < matrixArray.length; i++)
            matrixArray[i][col1] += matrixArray[i][col2];
    }


    //multiply the whole row by num
    public void multiplyRow(int row, double num) {

        if (num < 0)
            sign *= -1;


        for (int j = 0; j < matrixArray.length; j++) {
            matrixArray[row][j] *= num;
        }
    }


    //multiply the whole column by num
    public void multiplyCol(int col, double num) {

        if (num < 0)
            sign *= -1;

        for (int i = 0; i < matrixArray.length; i++)
            matrixArray[i][col] *= num;

    }


    // sort the cols from the biggest to the lowest value
    public void sortCol(int col) {

        for (int i = matrixArray.length - 1; i >= col; i--) {
            for (int k = matrixArray.length - 1; k >= col; k--) {
                double tmp1 = matrixArray[i][col];
                double tmp2 = matrixArray[k][col];

                if (Math.abs(tmp1) < Math.abs(tmp2))
                    replaceRow(i, k);
            }
        }
    }


    //replace row1 with row2
    public void replaceRow(int row1, int row2) {

        if (row1 != row2)
            sign *= -1;

        double[] tempRow = new double[matrixArray.length];

        for (int j = 0; j < matrixArray.length; j++) {
            tempRow[j] = matrixArray[row1][j];
            matrixArray[row1][j] = matrixArray[row2][j];
            matrixArray[row2][j] = tempRow[j];
        }
    }


    //replace col1 with col2
    public void replaceCol(int col1, int col2) {

        if (col1 != col2)
            sign *= -1;

        System.out.printf("replace col%d with col%d, sign = %d%n", col1, col2, sign);
        double[][] tempCol = new double[matrixArray.length][1];

        for (int i = 0; i < matrixArray.length; i++) {
            tempCol[i][0] = matrixArray[i][col1];
            matrixArray[i][col1] = matrixArray[i][col2];
            matrixArray[i][col2] = tempCol[i][0];
        }
    }


}