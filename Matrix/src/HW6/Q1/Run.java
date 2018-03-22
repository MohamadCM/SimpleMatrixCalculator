package HW6.Q1;

import java.util.Scanner;

/**
 * This class is used to start programme,
 * get matrices,
 * and calls the calculators
 * @author  Mohamad Chaman-Motlagh
 * @version 1
 */
public class Run {
    public static void main(String[] args) {
        TextProcessor textProcessor = new TextProcessor();
        Matrix X = new Matrix();
        System.out.println("Please enter the first matrix (X):");
        X.createMatrix(textProcessor.textScanner());
        Matrix Y = new Matrix();
        System.out.println("Please enter the second matrix (Y):");
        Y.createMatrix(textProcessor.textScanner());
        if(!X.check() || !Y.check())
        {
            System.out.println("Wrong input");
            return;
        }
        System.out.println("Please enter your polynomial expression (Use capital X and capital Y): ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str.replaceAll("\\s+","");
        if(textProcessor.xComesFirst(str))
            Matrix.finalCalculatorNormal(str,X,Y);
        else
            Matrix.finalCalculatorFlipped(str,X,Y);
    }
}
