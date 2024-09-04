/***
 * Task 5: Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
	● Input: s = "abcabcbb"
	● Output: 3
	● Explanation: The answer is "abc", with the length of 3.
 * Owner : Suhani Mathur
 * Created : 2/9/24
 * Updated : 3/9/24
 */


package com.Studyopedia;
import java.util.Scanner;

public class LongestSubstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println(Inputs.Longest_Substring);
        String s = scanner.nextLine();  // Read the user input string

        // Calculate and print the length of the longest unique substring
        int length = lengthOfLongestSubstring(s);
        System.out.println("Length : " + length);

        // Close the scanner
        scanner.close();
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[256]; // Assuming ASCII characters
        int maxLength = 0;
        int start = 0;
        int n = s.length();

        // Initialize array with -1 to signify no character is seen yet
        for (int i = 0; i < 256; i++) {
            charIndex[i] = -1;
        }

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);

            // Update the start index to the right of the last occurrence of the current character
            if (charIndex[currentChar] >= start) {
                start = charIndex[currentChar] + 1;
            }
            charIndex[currentChar] = end;

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}