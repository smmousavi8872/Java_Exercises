import java.math.BigDecimal;

public class Matrix {


    private double[][] valueArray;
    private int dimention;


    public double[][] getValueArray() {

        return cloneValueArray(valueArray);
    }


    public int getDimention() {
        return dimention;
    }


    public void setMatrixElement(int i, int j, double element) {
        valueArray[i][j] = element;
    }


    public Matrix(double[][] valueArray) {
        dimention = valueArray.length;
        this.valueArray = new double[dimention][dimention];
        this.valueArray = cloneValueArray(valueArray);
    }

    public BigDecimal getDeterminant() {

        DeterminantCalc determinantCalc = new DeterminantCalc(this);
        return determinantCalc.determinant();
    }

    public Matrix getTriangular() {

        DeterminantCalc determinantCalc = new DeterminantCalc(this);
        determinantCalc.makeTriangular();
        return new Matrix(determinantCalc.getMatrixArray());
    }

    public boolean isUpperTriangular() {
        DeterminantCalc determinantCalc = new DeterminantCalc(this);

        return determinantCalc.isUpperTriangular();

    }


    public boolean isLowerTriangular() {
        DeterminantCalc determinantCalc = new DeterminantCalc(this);

        return determinantCalc.isLowerTriangular();

    }


    public void draw() {
        for (int i = 0; i < valueArray.length; i++) {
            for (int j = 0; j < valueArray.length; j++) {
                System.out.printf("%15.2f", valueArray[i][j]);
            }
            System.out.println();
        }
    }


    public double[][] cloneValueArray(double[][] array) {

        int row = dimention;
        int col = dimention;
        double[][] newArray = new double[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newArray[i][j] = array[i][j];

            }
        }
        return newArray;
    }


}
