package fi.tuni.tamk.tiko.jerejoensuu;

import fi.tuni.tamk.tiko.jerejoensuu.util.Math;
import fi.tuni.tamk.tiko.jerejoensuu.util.Arrays;
import fi.tuni.tamk.tiko.jerejoensuu.util.MyConsole;
import fi.tuni.tamk.tiko.jerejoensuu.util.Properties;
import java.io.IOException;
import java.io.Console;

/**
 * The main class of the lotto application. Contains the main functionality of the app.
 */

public class Main {
    /**
     * The main method of the application.
     * 
     * @param args The lottery numbers can also be inputted in the program parameters.
     */

    // The length of the lotto.
    static int lottoLength = 7;
    static int [] lotto = new int [lottoLength];
    // Upper range of numbers used for the lotto.
    static int numbersToUse = 40;
    static int [] numbersToCopy = new int [numbersToUse];

    public static void main(String [] args) throws IOException {
        String SettingsFileLocation = "fi/tuni/tamk/tiko/jerejoensuu/util/Settings.properties";
        String Language = Properties.getString(SettingsFileLocation, "language");
        String Locale = "";
        if (!Language.equals("")) {
            Locale = "_" + Language;
        }
        String LangFileLocation = "fi/tuni/tamk/tiko/jerejoensuu/util/lang/MessagesBundle"+ Locale +".properties";

        Console c = System.console();
        int [] userNumbers = new int [lottoLength];
        int [] lottoNumbers = new int [lottoLength];
        int userInput = 0;
        int weeks = 0;
        int numbersCorrect = 0;
        numbersToCopy = Math.fillArray(1, numbersToUse);
        String [] TempArray = new String [lottoLength];
        int temp = 0;
        String UserInput = "";

        final String Request5 = Properties.getString(LangFileLocation, "request5");
        final String Affirmative = Properties.getString(LangFileLocation, "affirmative");
        final String Negative = Properties.getString(LangFileLocation, "negative");

        if (args.length == 0) {
            for (int i = 0; i < lottoLength; i++) {
                System.out.println(Properties.getString(LangFileLocation,"request1","(1-"+numbersToUse+")") + " (" + (i+1) + "/" + lottoLength + "): ");
                userInput = MyConsole.readInt(1,numbersToUse,Properties.getString(LangFileLocation,"request2"),Properties.getString(LangFileLocation,"request3","(1-"+numbersToUse+")"));
                if (Arrays.contains(userInput,userNumbers)) {
                    System.out.println(Properties.getString(LangFileLocation, "request4"));
                    i--;
                } else {
                    userNumbers[i] = userInput;
                }
            }
        } else {
            for (int i = 0; i < args.length; i++) {
                userNumbers[i] = Integer.parseInt(args[i]);
            }
        }

        boolean printNumbers = false;
        String WinningNumbersInquiry = Request5 + "(" + Affirmative + "/" + Negative + ")";
        if (Properties.getBoolean(SettingsFileLocation, "WinningNumbersInquiry")) {
            while (true) {
                System.out.println(WinningNumbersInquiry);
                UserInput = c.readLine();
                if (UserInput.equalsIgnoreCase(Affirmative) || UserInput.charAt(0) == Character.toLowerCase(Affirmative.charAt(0))) {
                    printNumbers = true;
                    break;
                } else if (UserInput.equalsIgnoreCase(Negative) || UserInput.charAt(0) == Character.toLowerCase(Negative.charAt(0))) {
                    printNumbers = false;
                    break;
                }
            }
        }

        while (true) {
            lottoNumbers = calculateLotto();
            weeks++;

            temp = Arrays.containsSameValues(userNumbers, lottoNumbers);
            if (temp > numbersCorrect) {
                numbersCorrect = temp;
                System.out.println(Properties.getString(LangFileLocation, "success1", Integer.toString(numbersCorrect)) + " " + Properties.getString(LangFileLocation, "success2", Integer.toString(weeks/52)));
                if (printNumbers) {
                    userNumbers = Arrays.selectionSort(userNumbers, true);
                    lottoNumbers = Arrays.selectionSort(lottoNumbers, true);
                    TempArray = Arrays.setLeadingZeroes(userNumbers, 2);
                    System.out.print(Properties.getString(LangFileLocation, "information1"));
                    printLottoNumbers(TempArray);
                    System.out.println();
                    TempArray = Arrays.setLeadingZeroes(lottoNumbers, 2);
                    System.out.print(Properties.getString(LangFileLocation, "information2"));
                    printLottoNumbers(TempArray);
                    System.out.println();
                    System.out.println();
                }
                if (numbersCorrect == lottoLength) {
                    System.out.print(Properties.getString(LangFileLocation, "success3"));
                    if ((weeks/52) > 120 && Properties.getBoolean(SettingsFileLocation, "LifetimeCheck")) {
                        System.out.println(" " + Properties.getString(LangFileLocation, "information3"));
                        System.out.println();
                        numbersCorrect = 0;
                        weeks = 0;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Returns an int array filled with random unique values between 1-40.
     * @return The lotto numbers.
     */

    private static int[] calculateLotto() {

        int [] numbers = numbersToCopy;
        int temp = 0;
        int index = 0;
        for (int i = 0; i < lottoLength; i++) {
            temp = Math.getRandom(0, numbers.length-1);
            lotto[i] = numbers[temp];
            index = numbers[temp];
            numbers = Math.removeIndex(index, numbers);
        }

        return lotto;

    }

    /**
     * The method responsible for printing the lotto numbers.
     * 
     * @param Array The array containing the numbers.
     */

    private static void printLottoNumbers(String [] Array) {
        System.out.print("[");
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i]);
            if (i < Array.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
