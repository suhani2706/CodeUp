/***
 * Task: When the program is run, the user will first enter a string. After that, the program shouldask the user which operation they want to execute on the string.
  		The available operations are listed below: 
  		Append, CountWords, Replace, isPalindrome, Splice, Split, MaxRepeatingCharacter, Sort, Shift, and Reverse. 
  		Each method should perform its respective operation based on the user's input.
 * Owner : Suhani Mathur
 * Created : 4/9/24
 */
		

package com.Studyopedia;

import java.util.Scanner;

public class MultiProgram {

    
    private static String CurrString = ""; 
    
    public static boolean isPalindrome(String input) {
        int i = 0;
        int j = input.length() - 1;
        
        while (i < j) {  
            if (input.charAt(i) != input.charAt(j)) {  
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public static void append(String newString) {
        if (CurrString.length() > 0) {
        	CurrString += " ";  
        }
        CurrString += newString;
    }
    public static String ReverseString(String s){     
        
        String reveString = "";
        for(int i = s.length() - 1; i >=0 ; i-- ){            
            reveString += s.charAt(i);
        }        
        return reveString;
    }
    public static String sort(String s) {
        char[] ch = s.toCharArray(); 
        bubbleSort(ch); 
        return new String(ch); 
    }

    private static void bubbleSort(char[] arr) {
        int n = arr.length;
        char temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static char maxRepeat(String CurrString) {
    	if (CurrString.length() == 0) {
            System.out.println("Current string is empty. Cannot determine the most frequent character.");
            return '\0'; 
        }

        int[] frequency = new int[256]; 
        char maxChar = '\0'; 
        int maxCount = 0; 

        
        for (int i = 0; i < CurrString.length(); i++) {
            char c = CurrString.charAt(i);
            frequency[c]++;

            
            if (frequency[c] > maxCount) {
                maxCount = frequency[c];
                maxChar = c;
            }
        }

        System.out.println("Character '" + maxChar + "' appears the most: " + maxCount + " times");
        return maxChar;
    }
    
    public static int countWords(String input) {
        if (input.length() == 0) {
            System.out.println("The input string is empty. Word count is 0.");
            return 0;
        }

        int wordCount = 0;
        boolean isWord = false;
        int endOfLine = input.length() - 1;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                isWord = true;
            } else if (input.charAt(i) == ' ' && isWord) {
                wordCount++;
                isWord = false;
            }

            if (i == endOfLine && isWord) {
                wordCount++;
            }
        }

        System.out.println("Total word count: " + wordCount);
        return wordCount;
    }


    
    public static void User_handle(String User_choice) {
    	Scanner sc = new Scanner(System.in);
    	String User_input;
    	
    	switch (User_choice) {
        case "1":
            System.out.println("Enter strings to append (type 'exit' to finish):");
            do {
                User_input = sc.nextLine();
                if (!User_input.equals("exit")) {
                    append(User_input);
                    System.out.println("Current String: " + CurrString);
                }
            } while (!User_input.equals("exit"));
            break;

        case "2":
        	
        	System.out.println("Enter a string to reverse :");
        	 do {
                 User_input = sc.nextLine();
                 if (!User_input.equals("exit")) {
                	 
                    System.out.println(ReverseString(User_input));
                 }
             } while (!User_input.equals("exit"));
            
           
            break;

        case "3":
        	System.out.println("Enter a string to sort :");
       	 do {
                User_input = sc.nextLine();
                if (!User_input.equals("exit")) {
               	 
                   System.out.println(sort(User_input));
                }
            } while (!User_input.equals("exit"));            
       	 break;
            
        case "4":
        	System.out.println("Enter a string to find the most frequent character: ");
        	User_input = sc.nextLine();
        	if (User_input.length() == 0) {
                System.out.println("Current string is empty. Cannot find the most frequent character.");
            } else {
                maxRepeat(User_input); 
            }
            break;
            
        case "5":
            System.out.println("Enter a string to find it's Palindrome : ");
            User_input = sc.nextLine();
            if(User_input.length() == 0) {
            	System.out.println("Current String is empty. Kindly enter one");
            }else {
            	if (isPalindrome(User_input)) {
                    System.out.println("The string '" + User_input + "' is a palindrome.");
                } else {
                    System.out.println("The string '" + User_input + "' is not a palindrome.");
                }
            }
            break;

        case "6":
        	System.out.println("Enter a string to count the words:");
            User_input = sc.nextLine(); 
            countWords(User_input); 
            break;
//
//        case "7":
//            operation7();
//            break;
//
//        case "8":
//            operation8();
//            break;
//
//        case "9":
//            operation9();
//            break;
//
//        case "10":
//            operation10();
//            break;

        case "exit":
            System.out.println("Exiting...");
            sc.close();
            return;

        default:
            System.out.println("Invalid choice. Please try again.");
            break;
    }
    }
    

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String User_choice;
        

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Append strings");
            System.out.println("2. Reverse current string");
            System.out.println("3. Sort a string");
            System.out.println("4. Find the max character fequency");
            System.out.println("5. Find Palindrome");
            System.out.println("6. Count the words in the string.");
            System.out.println("7. Operation 7");
            System.out.println("8. Operation 8");
            System.out.println("9. Operation 9");
            System.out.println("10. Operation 10");
            System.out.println("Type 'exit' to quit");

            User_choice = sc.nextLine();
            

            if (User_choice.equals("exit")) {
                System.out.println("Exiting...");
                sc.close();
                return;
            }

            User_handle(User_choice);
            
        }
    }
}

