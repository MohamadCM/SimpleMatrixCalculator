package HW6.Q1;

import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        TextProcessor textProcessor = new TextProcessor();
        Matrix matrix = new Matrix();
        matrix.createMatrix(textProcessor.textScanner());
        matrix.multiplyByNumber(2).print();
        matrix.print();
    }
}
