package HW6.Q1;

import java.util.Scanner;

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
        switch (textProcessor.situationFinder(str))
        {
            case (-1):
                System.out.println("Wrong expression");
                break;
            case (1):
                X.multiplyByNumber(textProcessor.factorOfXFinder(str)).print();
                break;
            case (2):
                if(str.charAt(0) == '-')
                    Y.multiplyByNumber(-textProcessor.factorOfYFinder("0X  + " + str)).print();
                else
                    Y.multiplyByNumber(textProcessor.factorOfYFinder("0X + " + str)).print();
                break;
            case (3):
                if(X.multiply(Y) != null)
                    X.multiplyByNumber(textProcessor.factorOfXFinder(str)).multiply(Y.multiplyByNumber(textProcessor.factorOfYFinder(str))).print();
                break;
            case (4):
                if(X.sum(Y) != null)
                    X.multiplyByNumber(textProcessor.factorOfXFinder(str)).sum(Y.multiplyByNumber(textProcessor.factorOfYFinder(str))).print();
                break;
            case (5):
                if(X.sum(Y) != null)
                    X.multiplyByNumber(textProcessor.factorOfXFinder(str)).sum(Y.multiplyByNumber(-textProcessor.factorOfYFinder(str))).print();
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
}
