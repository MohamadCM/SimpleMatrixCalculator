package HW6.Q1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class does processes on text
 * like getting input String and changing it
 * to an ArrayList of Doubles
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class TextProcessor {

    /**
     * This method gets input from user (until user enters one blank line)
     * and put the whole input in an ArrayList of Strings
     * @return an ArrayList of Strings of given input
     */
    public ArrayList<String> textScanner()
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<String>();
        String tempString;
        while(scanner.hasNextLine())
        {
            tempString = scanner.nextLine();
            if(tempString.equals(""))
                break;
            str.add(tempString);
        }
        return str;
    }

    /**
     * This method gets one String in the specified format
     * and put numbers in that String in an ArrayList of Doubles
     * @param str is given string
     * @return an ArrayList of Doubles (called a row of matrix)
     */
    public ArrayList<Double> rowGiver(String str)
    {
        ArrayList<Double> row = new ArrayList<Double>();
        int j = 0;
        for(int i = 0 ; i < numberOfDoulbes(str) ; i++)
        {
            String tempString = "";
            for ( ; (j < str.length()) && (str.charAt(j) != ',') ; j++)
                tempString += String.valueOf(str.charAt(j));
            row.add(Double.parseDouble(tempString));
            j++;
        }
        return row;
    }

    /**
     * Counts how many numbers exist in given String
     * @param str is given string
     * @return number of doubles in given string
     */
    public int numberOfDoulbes(String str)
    {
        int size = 0;
        for(int i = 0 ; i < str.length() ; i++)
            if(str.charAt(i) == ',')
                size++;
        size++;
        return size;
    }
}
