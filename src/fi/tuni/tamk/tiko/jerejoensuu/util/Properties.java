package fi.tuni.tamk.tiko.jerejoensuu.util;

import java.io.IOException;
import java.io.FileReader;


/**
 * A class for various language based settings for programs.
 * 
 * @author Jere Joensuu
 */

public class Properties {

    /**
     * Fetches a String from a file according to the given key. Ignores any comments marked by " //".
     * 
     * The file must follow the following format: *key* = *value* *"// possible comment"*
     * The last entry of the file must also be followed by a linebreak.
     * 
     * @param FileLocation The location of the file containing the Strings.
     * @param KeyString The key marking the Strings.
     * @return The String fetched from the file.
     * @throws IOException When encountering an error caused by the FileReader.
     */
    
    public static String getString(String FileLocation, String KeyString) throws IOException {
        KeyString += " = ";
        String Temp = "";
        String Translation = "";
        FileReader filereader = new FileReader (FileLocation);
        FileReader filereader2 = new FileReader (FileLocation);
        while (filereader.read() != -1) {
            Temp += (char)filereader2.read();
            if (Temp.charAt(Temp.length()-1) == '\n') {
                for (int i = 0; i < Temp.length()-1; i++) {
                    if (Temp.charAt(i) != KeyString.charAt(i)) {
                        break;
                    } else if (i == KeyString.length()-1) {
                        for (int i2 = i+1; i2 < Temp.length()-2; i2++) {
                            if (Temp.charAt(i2) == ' ' && Temp.charAt(i2+1) == '/' && Temp.charAt(i2+2) == '/') {
                                break;
                            }
                            Translation += Temp.charAt(i2);
                        }
                        break;
                    }
                }
                Temp = "";
            }
        }
        filereader.close();
        filereader2.close();
        return Translation;
    }

    /**
     * Fetches a String from a file according to the given key. Ignores any comments marked by " //".
     * Places the String Information at the point marked by "\i".
     * 
     * The file must follow the following format: *key* = *value* *"// possible comment"*
     * The last entry of the file must also be followed by a linebreak.
     * 
     * @param FileLocation The location of the file containing the Strings.
     * @param KeyString The key marking the Strings.
     * @param Information String replacing "\i" in the file.
     * @return The String fetched from the file.
     * @throws IOException When encountering an error caused by the FileReader.
     */

    public static String getString(String FileLocation, String KeyString, String Information) throws IOException {
        KeyString += " = ";
        String Temp = "";
        String Translation = "";
        FileReader filereader = new FileReader (FileLocation);
        FileReader filereader2 = new FileReader (FileLocation);
        while (filereader.read() != -1) {
            Temp += (char)filereader2.read();
            if (Temp.charAt(Temp.length()-1) == '\n') {
                for (int i = 0; i < Temp.length()-1; i++) {
                    if (Temp.charAt(i) != KeyString.charAt(i)) {
                        break;
                    } else if (i == KeyString.length()-1) {
                        for (int i2 = i+1; i2 < Temp.length()-1; i2++) {
                            if (Temp.charAt(i2) == ' ' && Temp.charAt(i2+1) == '/' && Temp.charAt(i2+2) == '/') {
                                break;
                            } else if (Temp.charAt(i2) == '\\' && Temp.charAt(i2+1) == 'i') {
                                Translation += Information;
                                i2 = i2 + 1;
                            } else {
                                Translation += Temp.charAt(i2);
                            }
                        }
                        break;
                    }
                }
                Temp = "";
            }
        }
        filereader.close();
        filereader2.close();
        return Translation;
    }

    /**
     * Fetches boolean value from the file marked by FileLocation. Ignores any comments marked by " //".
     * 
     * The file must follow the following format: *key* = *value* *"// possible comment"*
     * The last entry of the file must also be followed by a linebreak.
     * 
     * @param FileLocation Marks the location of the file the values are fetched from.
     * @param KeyString The value the method looks up from the file.
     * @return Returns the corresponding boolean value.
     * @throws IOException When the FileReader encounters an exception.
     */

    public static boolean getBoolean(String FileLocation, String KeyString) throws IOException{
        KeyString += " = ";
        String Temp = "";
        boolean value = false;
        FileReader filereader = new FileReader (FileLocation);
        FileReader filereader2 = new FileReader (FileLocation);
        while (filereader.read() != -1) {
            Temp += (char)filereader2.read();
            if (Temp.charAt(Temp.length()-1) == '\n') {
                for (int i = 0; i < Temp.length()-1; i++) {
                    if (Temp.charAt(i) != KeyString.charAt(i)) {
                        break;
                    } else if (i == KeyString.length()-1) {
                        for (int i2 = i+1; i2 < Temp.length()-1; i2++) {
                            if (Temp.charAt(i2) == ' ' && Temp.charAt(i2+1) == '/' && Temp.charAt(i2+2) == '/') {
                                break;
                            }
                            if (Temp.charAt(i2) == 't') {
                                value = true;
                            }
                        }
                        break;
                    }
                }
                Temp = "";
            }
        }
        filereader.close();
        filereader2.close();
        return value;
    }
}
