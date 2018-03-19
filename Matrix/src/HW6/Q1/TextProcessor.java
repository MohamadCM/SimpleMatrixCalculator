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
     *
     * @return an ArrayList of Strings of given input
     */
    public ArrayList<String> textScanner() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<String>();
        String tempString;
        while (scanner.hasNextLine()) {
            tempString = scanner.nextLine();
            if (tempString.equals(""))
                break;
            str.add(tempString);
        }
        return str;
    }

    /**
     * This method gets one String in the specified format
     * and put numbers in that String in an ArrayList of Doubles
     *
     * @param str is given string
     * @return an ArrayList of Doubles (called a row of matrix)
     */
    public ArrayList<Double> rowGiver(String str) {
        ArrayList<Double> row = new ArrayList<Double>();
        int j = 0;
        for (int i = 0; i < numberOfDoulbes(str); i++) {
            String tempString = "";
            for (; (j < str.length()) && (str.charAt(j) != ','); j++)
                tempString += String.valueOf(str.charAt(j));
            row.add(Double.parseDouble(tempString));
            j++;
        }
        return row;
    }

    /**
     * Counts how many numbers exist in given String
     *
     * @param str is given string
     * @return number of doubles in given string
     */
    public int numberOfDoulbes(String str) {
        int size = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ',')
                size++;
        size++;
        return size;
    }

    /**
     * Gets the ‫‪polynomial‬‬ ‫‪expression‬‬ as a String
     * and return an integer depending on ‫‪expression's situation
     * @param string is given ‫‪polynomial‬‬ ‫‪expression
     * @return int integer depending on situation of ‫‪polynomial‬‬ ‫‪expression
     */
    public int situationFinder(String string) {
        if (string.contains("*"))
            return 3;
        if (string.contains("+"))
            return 4;
        if (string.contains("-"))
            return 5;
        if (! (string.contains("Y")))
            return 1;
        if (! (string.contains("X")))
            return 2;
        if( ( !string.contains("Y") ) && ( !string.contains("X") ) )
            return -1;
        return 0;
    }

    /**
     * Gets the ‫‪polynomial‬‬ ‫‪expression‬‬ as a String
     * and return factor of X as a double value
     * @param str is given ‫‪polynomial‬‬ ‫‪expression‬‬ as a String
     * @return factor of X as a double
     */
    public double factorOfXFinder(String str) {
        double result;
        double flag = 1;
        if ((str.contains("X"))) {
            String tempString = "";
            if (str.charAt(0) == '(') {
                for (int i = 2; str.charAt(i) != ')'; i++)
                    tempString += String.valueOf(str.charAt(i));
                flag = -1;
            }
            else {
                if (str.charAt(0) == '-') {
                    for (int i = 1; str.charAt(i) != 'X'; i++)
                        tempString += String.valueOf(str.charAt(i));
                    flag = -1;
                }
                else
                    for (int i = 0; str.charAt(i) != 'X'; i++)
                        tempString += String.valueOf(str.charAt(i));
            }
            if(tempString.length() == 0)
                return 1;
            result = Double.parseDouble(tempString) * flag;
            return result;
        }
        return 0;
    }

    /**
     * Gets the ‫‪polynomial‬‬ ‫‪expression‬‬ as a String
     * and return factor of Y as a double value
     * Given str must have X character so that this method works correctly
     * (if no X available, we should put string like: 0X+bY)
     * @param str is given ‫‪polynomial‬‬ ‫‪expression‬‬ as a String
     * @return factor of Y as a double
     */
    public double factorOfYFinder(String str) {
        double result;
        double flag = 1;
        if ((str.contains("Y"))) {
            String tempString = "";
            if (str.charAt(str.indexOf("Y") -1) == ')') {
                for (int i = str.indexOf("-", str.indexOf("X") + 1) + 1 ; str.charAt(i) != ')'; i++)
                    tempString += String.valueOf(str.charAt(i));
                flag = -1;
            }
            else {
                if (str.indexOf("-", str.indexOf("X") + 1) != -1) {
                    for (int i = str.indexOf("-", str.indexOf("X") + 1) + 1 ; str.charAt(i) != 'Y'; i++)
                        tempString += String.valueOf(str.charAt(i));
                    flag = -1;
                }
                else {
                    for (int i = str.indexOf("X"); str.charAt(i) != 'Y'; i++)
                        tempString += String.valueOf(str.charAt(i));
                    String tempString2 = "";
                    for(int i = 0; i < tempString.length() ; i++)
                        if((tempString.charAt(i) >= '0' & tempString.charAt(i) <= '9') || tempString.charAt(i) == '.')
                            tempString2 += String.valueOf(tempString.charAt(i));
                    tempString = tempString2;
                }
            }
            if(tempString.length() == 0)
                return 1;
            result = Double.parseDouble(tempString) * flag;
            return result;
        }
        return 0;
    }

}