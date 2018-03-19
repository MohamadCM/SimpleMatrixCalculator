package HW6.Q1;
import java.util.ArrayList;

/**
 * This class keeps the matrix and
 * implements it's behaviors (Summation and Multiplication)
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class Matrix {
    //The Matrix is build by an ArrayList of ArrayLists of Doubles
    private ArrayList<ArrayList<Double>> matrix;

    /**
     * Each Matrix needs an nothing to get created
     */
    public Matrix() {
        matrix = new ArrayList<ArrayList<Double>>();
    }

    /**
     * Creates an completes the matrix by having an ArrayList of String
     *
     * @param strings is given ArrayList of String
     */
    public void createMatrix(ArrayList<String> strings) {
        TextProcessor textProcessor = new TextProcessor();
        for (int i = 0; i < strings.size(); i++) {
            matrix.add(textProcessor.rowGiver(strings.get(i)));
        }
    }

    /**
     * Checks the validity of matrix
     *
     * @return {@code true} if matrix is valid and {@code false} if matrix isn't valid
     */
    public boolean check() {
        for (int i = 1; i < matrix.size(); i++)
            if (matrix.get(i).size() != matrix.get(i - 1).size())
                return false;
        return true;
    }

    /**
     * Prints the Matrix
     */
    public void print() {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                System.out.print(matrix.get(i).get(j));
                if (j + 1 < matrix.get(0).size())
                    System.out.print(",");
            }
            System.out.println("");
        }
    }

    /**
     * @return number of rows in a matrix
     */
    public int numberOfRows() {
        return matrix.size();
    }

    /**
     * return number of columns in a matrix if matrix is valid,
     * or returns number of columns in the first row if matrix isn't valid
     *
     * @return number of columns in a matrix
     */
    public int numberOfColumns() {
        return matrix.get(0).size();
    }

    /**
     * @return ArrayList of ArrayList of Doubles of each Matrix
     */
    public ArrayList<ArrayList<Double>> getMatrix() {
        return matrix;
    }

    /**
     * Calculates summation of two matrices and returns the result as another matrix
     * @param matrix2 is given matrix to apply summation operation
     * @return result as another Matrix
     */
    public Matrix sum(Matrix matrix2) {
        if ((matrix.size() != matrix2.numberOfRows()) || (matrix.get(0).size() != matrix2.numberOfColumns())) {
            System.out.println("Wrong operation!");
            return null;
        }
        Matrix result = matrix2;
        for (int i = 0; i < matrix.size(); i++)
            for (int j = 0; j < matrix.get(0).size(); j++)
                result.getMatrix().get(i).set( j , matrix.get(i).get(j) + matrix2.getMatrix().get(i).get(j));
        return result;
    }

    /**
     * Calculates multiply of number and a Matrix
     * Returns result as another Matrix
     * @param num is number to append to Matrix
     * @return result Matrix
     */
    public Matrix multiplyByNumber(double num)
    {
        Matrix result = this;
        for (int i = 0; i < matrix.size(); i++)
            for (int j = 0; j < matrix.get(0).size(); j++)
                result.getMatrix().get(i).set( j , num * matrix.get(i).get(j));
        return result;
    }

    /**
     * Calculates subtract of two matrices and returns the result as another matrix
     * @param matrix2 is given matrix to apply subtraction operation
     * @return result as another Matrix
     */
    public Matrix sub(Matrix matrix2)
    {
        if ((matrix.size() != matrix2.numberOfRows()) || (matrix.get(0).size() != matrix2.numberOfColumns())) {
            System.out.println("Wrong operation!");
            return null;
        }
        return this.sum(matrix2.multiplyByNumber(-1));
    }
}