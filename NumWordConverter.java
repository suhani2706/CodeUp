/***
 * Task 4: Number to Words Converter
 * Write a Java program that converts a given integer into its written English form.
 * Example 1:
             ● Input: 51
             ● Output: "fifty one"
             ● Explanation:
             The number 51 is represented as "fifty" for 50 and "one" for 1.
 * Owner = Suhani Mathur
 * Date = 09/02/2024
 */





package com.Studyopedia;
import java.util.Scanner;

public class NumWordConverter 
{

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);       
    	System.out.println(Inputs.NumWord);
        int num = sc.nextInt();
        sc.close();

        if (num == 0) {
            System.out.println("zero");
        } else {
            System.out.println(convert(num));
        }
    }

    private static String convert(int num) {
        if (num == 0) return "";
        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + Inputs.Thousands[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private static String helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return Inputs.Ones[num] + " ";
        else if (num < 100) return Inputs.Tens[num / 10] + " " + Inputs.Ones[num % 10] + " ";
        else return Inputs.Ones[num / 100] + " hundred " + helper(num % 100);
    }


	
}