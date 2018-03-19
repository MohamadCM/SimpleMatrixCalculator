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
     * Setting a new ArrayList of ArrayList of Double for current Matrix
     * @param matrix is give ArrayList of ArrayList of Double
     */
    public void setMatrix(ArrayList<ArrayList<Double>> matrix) {
        this.matrix = matrix;
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
        Matrix result = new Matrix();
        ArrayList<ArrayList<Double>> resultArrayList = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < matrix.size(); i++) {
            resultArrayList.add(new ArrayList<Double>());
            for (int j = 0; j < matrix.get(0).size(); j++)
                resultArrayList.get(i).add(matrix.get(i).get(j) + matrix2.getMatrix().get(i).get(j));
        }
        result.setMatrix(resultArrayList);
        return result;
    }

    /**
     * Calculates multiply of number and a Matrix
     * Returns result as another Matrix
     * Subtraction is done by this method too
     * @param num is number to append to Matrix
     * @return result Matrix {@code null} if the operation isn't allowed
     */
    public Matrix multiplyByNumber(double num)
    {
        Matrix result = new Matrix();
        ArrayList<ArrayList<Double>> resultArrayList = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < matrix.size(); i++) {
            resultArrayList.add(new ArrayList<Double>()) ;
            for (int j = 0; j < matrix.get(0).size(); j++)
                resultArrayList.get(i).add(num * matrix.get(i).get(j));
        }
        result.setMatrix(resultArrayList);
        return result;
    }

    /**
     * Calculates multiplication of two matrices and returns the result as another matrix
     * @param matrix2 is given matrix to apply subtraction operation
     * @return result as another Matrix {@code null} if the operation isn't allowed
     */
    public Matrix multiply(Matrix matrix2)
    {
        if(this.numberOfColumns() != matrix2.numberOfRows()) {
            System.out.println("Wrong operation!");
            return null;
        }
        ArrayList<ArrayList<Double>> resultArrayList = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < this.numberOfRows(); i++) {
            resultArrayList.add(new ArrayList<Double>());
            for(int j = 0; j < matrix2.numberOfColumns(); j++) {
                double resKeeper = 0;
                for(int k = 0; k < this.numberOfColumns(); k++) {
                    resKeeper += this.getMatrix().get(i).get(k) * matrix2.getMatrix().get(k).get(j);
                }
                resultArrayList.get(i).add(resKeeper);
            }
        }
        Matrix result = new Matrix();
        result.setMatrix(resultArrayList);
        return result;
    }
}