package com.Studyopedia;
/***
 * Task 3: Prime Number Checker
 * Write a Java program to determine if a given integer is a prime number.
 * Example 1:
	● Input: 21
	● Output: "The given number is NOT prime"
	● Explanation:
		The number 21 is divisible by 3 and 7, hence it is not a prime number
 * Owner : Suhani Mathur
 * Created : 2/9/24
 * Updated : 3/9/24
 */




import java.util.Scanner;

public class PrimeNumChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        System.out.println(Inputs.Prime_Num);
        int n = scanner.nextInt();  
        if (isPrime(n)) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
        
        scanner.close();
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false; 
        if (n <= 3) return true;  
        
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}