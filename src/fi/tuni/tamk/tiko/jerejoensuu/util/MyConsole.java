
package fi.tuni.tamk.tiko.jerejoensuu.util;

import java.io.Console;  

/**
 * A console class that deals with various user input functions.
 * 
 * @author Jere Joensuu
 */

public class MyConsole {

    /**
     * Asks user for an integer value. If a non integer input is given,
     * the provided error message is displayed.
     * 
     * @param errorMessage The provided error message.
     * @return Returns user's input when it is an integer value.
     */

    public static int readInt(String errorMessage) {

        Console c = System.console(); 
        int input = 0;
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                input = Integer.parseInt(c.readLine());
                tryAgain = false;
            } catch(NumberFormatException e) {
                System.out.println(errorMessage);
                tryAgain = true;
            }
        }
        
        return input;

    }

    /**
     * Asks user for an integer value. If a non integer value or a value outside the specified range
     * is given, displays the provided error message.
     * 
     * @param min Minimun value expected.
     * @param max Maximum value expected.
     * @param errorMessageNonNumeric Error message displayed when user input is non-numeric.
     * @param errorMessageNonMinAndMax Error message displayed when user input is outside the specified range.
     * @return Returns user input when it meets the specified requirements.
     */

    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {

        Console c = System.console(); 
        int input = 0;
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                input = Integer.parseInt(c.readLine());
                tryAgain = false;
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
                tryAgain = true;
            }
            if (input < min || input > max) {
                System.out.println(errorMessageNonMinAndMax);
                tryAgain = true;
            }
        }
        
        return input;

    }

}