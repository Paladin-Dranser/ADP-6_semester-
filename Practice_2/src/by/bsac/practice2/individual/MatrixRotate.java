package by.bsac.practice2.individual;

/*
    Выканаць цыклічны зрух матрыцы на k элементаў (ва ўсе бакі)
 */

import java.util.Scanner;
import java.util.Random;

public class MatrixRotate {
    public static void main(String[] args) {
        System.out.print("Enter the size of matrix: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        Integer[][] matrix = new Integer[size][size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.ints(-size, (size + 1)).findFirst().getAsInt();
            }
        }

        System.out.println("The initial matrix:");
        printMatrix(matrix);

        Integer[][] matrixForShift = new Integer[size][size];

        System.out.print("Enter the number of shift: ");
        int shift = scan.nextInt();

        System.out.println("Matrix after left shift:");
        cloneMatrix(matrix, matrixForShift);
        for (int i = 0; i < size; i++) {
            Integer[] temp = new Integer[size];
            for (int j = 0; j < size; j++) {
                int newIndex = (j - shift >= 0) ? (j - shift) : (size + (j - shift));
                temp[newIndex] = matrixForShift[i][j];
            }
            System.arraycopy(temp, 0, matrixForShift[i], 0, size);
        }
        printMatrix(matrixForShift);

        System.out.println("Matrix after right shift:");
        cloneMatrix(matrix, matrixForShift);
        for (int i = 0; i < size; i++) {
            Integer[] temp = new Integer[size];
            for (int j = 0; j < size; j++) {
                int newIndex = (shift + j) % size;
                temp[newIndex] = matrixForShift[i][j];
            }
            System.arraycopy(temp, 0, matrixForShift[i], 0, size);
        }
        printMatrix(matrixForShift);

        System.out.println("Matrix after bottom shift:");
        cloneMatrix(matrix, matrixForShift);
        for (int i = 0, j = shift % size; j < size; i++, j++) {
            System.arraycopy(matrix[i], 0, matrixForShift[j], 0, size);
        }
        for (int i = size - shift % size, j = 0; j < shift % size; i++, j++) {
            System.arraycopy(matrix[i], 0, matrixForShift[j], 0, size);
        }
        printMatrix(matrixForShift);

        System.out.println("Matrix after top shift:");
        cloneMatrix(matrix, matrixForShift);
        for (int i = shift % size, j = 0; i < size; i++, j++) {
            System.arraycopy(matrix[i], 0, matrixForShift[j], 0, size);
        }
        for (int i = 0, j = size - (shift % size); i < shift % size; i++, j++) {
            System.arraycopy(matrix[i], 0, matrixForShift[j], 0, size);
        }
        printMatrix(matrixForShift);
    }

    public static void cloneMatrix(Integer[][] source, Integer[][] destination) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
        }
    }

    public static void printMatrix(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%4s", Integer.toString(matrix[i][j]));
            }
            System.out.println();
        }
    }
}
