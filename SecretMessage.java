/*
 * @author      Peter Jacobson
 * @class       CS 3 - 0112
 * @assingment  Secret Message (#02)
 * @lastUpdate  Jan 15, 2020
 *
 * CRASH NOTES *
 * None Known
 *      
 */

package secretmessage;
import static java.lang.Character.toLowerCase;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SecretMessage {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        //Varaibles
        String letters = "abcdefghijklmnopqrstuvwxyz";  //The Key (1/2)
        String enc = "kngcadsxbvfhjtiumylzqropwe";  //The Key (2/2)
        String input = "";
        String checkString;
        char checkInt;    //Used to check if unput it a var
        int isInt = 0;  //If checkInt is a number, we convert to int and assign it to isInt
       
        //loops program until stopped by user or crashe note
        do {    
            checkString = JOptionPane.showInputDialog("Enter 1 to encode, 2 to decode, 3 to quit: "); //Asks choice & inputs user number
            isInt = toInt(checkString);    //Sends input to be checked to be an int and cleaned up
           
            switch(isInt) {    //switch works based on user input
                case 1:   
                    input = JOptionPane.showInputDialog("Enter text to encode: ");  //inputs text to encode
                    encode(input, enc, letters);
                    break;
                case 2:         
                    input = JOptionPane.showInputDialog("Enter text to encode: ");  //inputs text to encode
                    decode(input, enc, letters);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "GoodBye.");
                    return; //ends the program
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input. Try again.");
                    break;
            }
        } while(true);
    }
    
    //encoding logic
    public static void encode(String input, String enc, String letters) {
        String replace = "";    //encoded string
        //parses through input char by char
        for (int i = 0; i < input.length(); i++){
            if(Character.isUpperCase(input.charAt(i))) { //checks for captial
                //gets the next character, converts to lowercase, finds it in letters, changes it to encoded equivalent, converts to uppercase, adds it to replace
                replace = replace + Character.toUpperCase(enc.charAt(letters.indexOf(Character.toLowerCase(input.charAt(i)))));
            }
            else if(!Character.isLetter(input.charAt(i)))
                //gets the non-letter and puts it directly into replace with no change
                replace = replace + input.charAt(i); 
            else if(input.charAt(i) != ' ') //if the next char isn't empty
                //gets the next char, finds it in letters, changes it to encoded equivalent, adds it to replace
                replace = replace + enc.charAt(letters.indexOf(input.charAt(i))); 
            else
                //catches the white space and adds it to replace
                replace = replace + " ";
        }
        JOptionPane.showMessageDialog(null, replace);
    }
    
    //decoding logic, basically the same as encode
    public static void decode(String input, String enc, String letters) {
        String replace = "";    //encoded string
        //parses through input char by char
        for (int i = 0; i < input.length(); i++){
            if(Character.isUpperCase(input.charAt(i))) { //checks for captial
                //gets the next character, converts to lowercase, finds it in enc, changes it to alphabetical equivalent, converts to uppercase, adds it to replace
                replace = replace + Character.toUpperCase(letters.charAt(enc.indexOf(Character.toLowerCase(input.charAt(i)))));
            }
            else if(!Character.isLetter(input.charAt(i)))
                //gets the non-letter and puts it directly into replace with no change
                replace = replace + input.charAt(i); 
            else if(input.charAt(i) != ' ') //if the next char isn't empty
                //gets the next char, finds it in enc, changes it to alphabetical equivalent, adds it to replace
                replace = replace + letters.charAt(enc.indexOf(input.charAt(i))); 
            else
                //catches the white space and adds it to replace
                replace = replace + " ";
        }
        JOptionPane.showMessageDialog(null, replace);
    }
    
    public static int toInt(String input) {
        int isInt;
        if (!isStringOfInts(input)) //returns -1 if the input string has letters
            return -1;
        else if(input.length() != 1)    //returns -1 if the input string is not one character long
            return -1;
        
        //Trys to make input into an integer for processing, otherwise it makes it zero 
        try {
            isInt = Character.getNumericValue(input.charAt(0)); //Puts the number char into an int
        } catch(Exception e) {
            isInt = -1; //if something other than a single int gets through it will be turned to -1
        }
        return isInt;
    }
    
    public static boolean isStringOfInts(String input) {
        //Parses through input to check for non-ints, returns false if non-int is found
        for(int i = 0; i < input.length(); i ++) {
            if(!Character.isDigit(input.charAt(i)))
                return false;
        }
        return true;    //returns true if no letters are found
    }
}
        
        