

package fi.tuni.tamk.tiko.jerejoensuu.util;

/**
* The class Math contains methods for basic mathematical functions.
*
*
* @author Jere Joensuu
*/

public class Math {

    /**
    * Return a random value from according to the min and max arguments.
    */

    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }

    /**
     * Fills an int array with values between the two given values.
     * 
     * For example, if given values 1 and 10 in the parameters, the method returns an array
     * of length 10, containing the numbers 1,2,3...10.
     * 
     * @param firstValue The first number of the array.
     * @param lastValue The last number of the array.
     * @return Returns an array filled with numbers.
     */

    public static int [] fillArray(int firstValue, int lastValue) {
        int temp = firstValue;
        int [] array = new int [lastValue-(firstValue-1)];

        for (int i = 0; i < array.length; i++) {
            array[i] = temp;
            temp++;
        }

        return array;
    }

    /**
     * Removes given index from an int array. Assumes array contains the given index
     * and that the array contains only unique values.
     * 
     * @param index Value removed from the array.
     * @param array Array index needs to be removed from.
     * @return Returns an array without the index. The length of the new array is the length
     * of the original array minus one.
     */

    public static int [] removeIndex(int index, int [] array) {
        int [] newArray = new int [array.length-1];
        int a = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == index) {
                i++;
            }
            newArray[a] = array[i];
            if (a == newArray.length-1) {
                return newArray;
            }
            a++;
        }

        return newArray;
    }
}