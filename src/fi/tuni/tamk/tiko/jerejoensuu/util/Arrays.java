
package fi.tuni.tamk.tiko.jerejoensuu.util;

/**
 * Contains various methods dealing with arrays.
 * 
 * @author Jere Joensuu
 */

public class Arrays {

    /**
     * Turns an int array into a string array and returns it.
     * 
     * @param array Given String array
     * @return returns new int array
     */

    public static int[] toIntArray(String[] array) {

        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }

        return intArray;
    }

    /**
     * Checks whether or not a given value exists in the given int array, and returns a boolean depending on the results.
     * 
     * @param value Contains the searched value.
     * @param array The int array the value is searched from.
     * @return Returns "true" if the array contains the value, "false" if not.
     */
    public static boolean contains(int value, int[] array) {

        boolean doesContain = false;
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                doesContain = true;
                break;
            }
        }

        return doesContain;

    }

    /**
     * Checks how many values two arrays have in common. Returns the number of shared values.
     * 
     * @param array1 First array
     * @param array2 Second array
     * @return Number of shared values between given arrays.
     */
    
    public static int containsSameValues(int [] array1, int [] array2) { 

        int sameValues = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int i2 = 0; i2 < array2.length; i2++) {
                if (array1[i] == array2[i2]) {
                    sameValues++;
                }
            }
        }

        return sameValues;
    }

    /**
     * A selection sorting method for int arrays.
     * 
     * @param array The array in need of sorting.
     * @param sortLowestToHighest Determines sorting order.
     * @return The sorted array 
     */

    public static int [] selectionSort(int [] array, boolean sortLowestToHighest) {
        int temp = 0;
        int temp2 = 0;
        int n = 0;
        int location = 0;
        while (n != array.length) {
            temp = array[n];
            for (int a = n; a <= array.length - 1; a++) {
                if (sortLowestToHighest) {
                    if (temp >= array[a]) {
                        temp = array[a];
                        location = a;
                    }
                } else {
                    if (temp <= array[a]) {
                        temp = array[a];
                        location = a;
                    }
                }
                if (a == array.length - 1) {
                    temp2 = array[n];
                    array[n] = temp;
                    array[location] = temp2;
                    n++;
                }
            }    
        }
        return array;
    }

    public static String [] setLeadingZeroes(int [] array, int numberOfDigits) {
        String [] StringArray = new String [array.length];
        // automatically find highest digit amount in array
        for (int i = 0; i < array.length; i++) {
            StringArray[i] = array[i] + "";
            if (StringArray[i].length() > numberOfDigits || numberOfDigits == 0) {
                numberOfDigits = StringArray[i].length();
            }
        }
        // set leading zeroes
        String Temp = "";
        for (int a = 0; a < StringArray.length; a++) {
            Temp = StringArray[a];
            StringArray[a] = "";
            for (int a2 = Temp.length(); a2 < numberOfDigits; a2++) {
                StringArray[a] += "0";
            }
            StringArray[a] += Temp;
        }

        return StringArray;
    }
}