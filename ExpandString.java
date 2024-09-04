/***
 * Task 1: Expand Characters in a String
 * Given a string containing characters followed by digits, expand each character by repeating it according to the digit that follows.
 * Example 1:
		● Input: "a1b4c3"
		● Output: "abbbbccc"
		● Explanation:
				The character 'a' is followed by 1, so it appears once.
				The character 'b' is followed by 4, so it appears four times: "bbbb".
				The character 'c' is followed by 3, so it appears three times: "ccc".
 * Owner : Suhani Mathur
 * Created : 2/9/24
 * Updated : 3/9/24
 */

package com.Studyopedia;
import java.util.Scanner;

public class ExpandString {

    public static String expString(String s) {
        
        if (!isValidFormat(s)) {
            return "Dude, write like what is given in example :|";
        }

        String result = "";
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            i++; 

            
            int count = 0;
            while (i < s.length() && isDigit(s.charAt(i))) {
                count = count * 10 + (s.charAt(i) - '0');
                i++;
            }

            
            for (int k = 0; k < count; k++) {
                result += ch;
            }
        }

        return result;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isValidFormat(String s) {
        if (s.isEmpty() || !isLetter(s.charAt(0))) {
            return false;
        }

        int i = 0;
        while (i < s.length()) {
            
            if (!isLetter(s.charAt(i))) {
                return false;
            }

            i++; 

            
            if (i >= s.length() || !isDigit(s.charAt(i))) {
                return false;
            }

           
            while (i < s.length() && isDigit(s.charAt(i))) {
                i++;
            }

            
            if (i < s.length() && !isLetter(s.charAt(i)) && !isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(Inputs.String_Expansion);
        String s = sc.nextLine();

        String expandedString = expString(s);
                
        System.out.println(expandedString);
                
        sc.close();
    }
}