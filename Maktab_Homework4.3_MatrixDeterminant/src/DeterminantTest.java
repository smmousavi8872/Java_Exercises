import java.text.NumberFormat;
import java.util.Scanner;


public class DeterminantTest {

    private static Scanner scanner = new Scanner(System.in);
    private static double[][] inputMatrix;
    private static Matrix matrix;

    public static void main(String[] args) {


        //generating random numbers
        /* int len = 300;
        SecureRandom random = new SecureRandom();
        inputMatrix = new double[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                inputMatrix[i][j] = random.nextInt(500);
                //System.out.printf("%15.2f", valueArray[i][j]);
            }
        }
        System.out.println(); */


        /* double[][] inputMatrix = {
            {1, 5, 2, -2, 3, 2, 5, 1, 0, 5},
            {4, 6, 0, -2, -2, 0, 1, 1, -2, 1},
            {0, 5, 1, 0, 1, -5, -9, 0, 4, 1},
            {2, 3, 5, -1, 2, 2, 0, 4, 5, -1},
            {1, 0, 3, -1, 5, 1, 0, 2, 0, 2},
            {1, 1, 0, -2, 5, 1, 2, 1, 1, 6},
            {1, 0, 1, -1, 1, 1, 0, 1, 1, 1},
            {1, 5, 5, 0, 3, 5, 5, 0, 0, 6},
            {1, -5, 2, -2, 3, 2, 5, 1, 1, 5},
            {1, 5, -2, -2, 3, 1, 5, 0, 12, 1}
        }; */


        /* Matrix matrix = new Matrix(inputMatrix);
        String determinant = NumberFormat.getInstance().format(matrix.getDeterminant());

        matrix.getTriangular().draw();
        System.out.println();
        matrix.draw();
        System.out.println();
        System.out.printf("%s%s%n", "Determinant: ", determinant); */

        setMarix();

        outter:
        while (true) {
            int choice;
            System.out.println("choose operation: ");
            System.out.println("1. calculate determinant. ");
            System.out.println("2. is uppertriangular?");
            System.out.println("3. is lowertriangular?");
            System.out.println("4. draw triangular matrix.");
            System.out.println("5. draw original matrix.");
            System.out.println("6. change matrix.");
            System.out.println("7. eixt.");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    String determinant = NumberFormat.getInstance().format(matrix.getDeterminant());
                    System.out.println("Determinant: " + determinant);
                    break;
                case 2:
                    System.out.println(matrix.isUpperTriangular() ? "Yes" : "No");
                    break;
                case 3:
                    System.out.println(matrix.isLowerTriangular() ? "Yes" : "No");
                    break;
                case 4:
                    matrix.getTriangular().draw();
                    System.out.println();
                    break;
                case 5:
                    matrix.draw();
                    System.out.println();
                    break;
                case 6:
                    setMarix();
                    break;
                case 7:
                    System.out.println("come back soon.");
                    break outter;
                default:
                    System.out.println("Wrong choice!");
            }

        }

    }


    public static void setMarix() {

        System.out.print("Matrix Dimension: ");
        int dim = scanner.nextInt();

        inputMatrix = new double[dim][dim];

        System.out.println("Set the Matrix: ");

        for (int i = 0; i < dim; i++) {
            System.out.printf("%5s%d%n", "row", i + 1);
            for (int j = 0; j < dim; j++) {
                System.out.printf("M[%d][%d] = ", i + 1, j + 1);
                inputMatrix[i][j] = scanner.nextDouble();

            }
            System.out.println();

        }
        matrix = new Matrix(inputMatrix);
    }


}
