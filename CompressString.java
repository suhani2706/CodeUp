/***
 * Task 2: Character Frequency in a String
 * Write a Java program that takes a string input and outputs the frequency of each character in a compressed form.
 * Example 1:
		● Input: "aabcccdeee"
		● Output: "a2b1c3d1e3"
		● Explanation:
				The character 'a' appears 2 times.
				The character 'b' appears 1 time.
				The character 'c' appears 3 times.
				The character 'd' appears 1 time.
				The character 'e' appears 3 times.
				Concatenating these frequencies results in "a2b1c3d1e3".
 * Owner : Suhani Mathur
 * Created : 2/9/24
 * Updated : 3/9/24
 */

package com.Studyopedia;

import java.util.Scanner;

public class CompressString {

   
    public static String compressString(String str) {
        String comp = "";
        int count = 1;

        
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                comp += str.charAt(i) + String.valueOf(count);
                count = 1;
            }
        }
        if (comp.length() < str.length()) {
            return comp;
        } else {                        
            return str;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        System.out.println(Inputs.String_Compression);
        String input = scanner.nextLine();        
        String result = compressString(input);        
        System.out.println("Compressed String: " + result); 
       
        
    }
}