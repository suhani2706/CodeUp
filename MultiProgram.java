/***
 * Task: When the program is run, the user will first enter a string. After that, the program should ask the user which operation they want to execute on the string.
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
    public static char maxRepeat(String userInput) {
    	if (CurrString.length() == 0) {
            System.out.println("Current string is empty. Cannot determine the most frequent character.");
            return '\0'; 
    	}
            int maxCount = 0;  
            char maxChar = ' '; 
       
            for (int i = 0; i < userInput.length(); i++) {
                char currentChar = userInput.charAt(i);
                int count = 0;

                
                for (int j = 0; j < userInput.length(); j++) {
                    if (userInput.charAt(j) == currentChar) {
                        count++;
                    }
                }

                
                if (count > maxCount) {
                    maxCount = count;
                    maxChar = currentChar;
                }
            }

           
            System.out.println(maxChar + " -> " + maxCount);

            return maxChar;
    }
    
    public static int countWords(String input) {
        if (input.length() == 0) {
            System.out.println("The input string is empty. Word count is 0.");
            return 0;
        }

        int wordCount = 0;
        boolean EndingWord = false;
        int endOfLine = input.length() - 1;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
            	EndingWord = true;
            } else if (input.charAt(i) == ' ' && EndingWord) {
                wordCount++;
                EndingWord = false;
            }

            if (i == endOfLine && EndingWord) {
                wordCount++;
            }
        }

        System.out.println("Total word count: " + wordCount);
        return wordCount;
    }
    
    public static String Splice(String str, int start, int length) {
        
        if (start < 0 || start >= str.length() || length < 0 || start + length > str.length()) {
            return "Invalid parameters";
        }
        
        String result = "";        
        
        for (int i = 0; i < start; i++) {
            result += str.charAt(i);
        }      
        
        for (int i = start + length; i < str.length(); i++) {
            result += str.charAt(i);
        }
        
        return result;
    }

    public static void modifyString(String mainString, String toReplace, String replaceWith)
    {
      
      String newString = "";      
      for (int i = 0; i < mainString.length(); i++) {   
        int k = 0;       
        
        if (mainString.charAt(i) == toReplace.charAt(k)
            && i + toReplace.length() <= mainString.length()) {
        	
          int j;
          for (j = i; j < i + toReplace.length(); j++) {   
            if (mainString.charAt(j) != toReplace.charAt(k)) {
              break;
            }
            else {
              k = k + 1;
            }
          }   
          if (j == i + toReplace.length()) {
        	  newString += (toReplace);
            i = j - 1;
          }        
          else {
        	  newString += (mainString.charAt(i));
          }
        }    
        else {
        	newString += (mainString.charAt(i));
        }
      }      
      System.out.println("New string :" + newString);
    }
    
    public static String[] split(String str, char delimiter) {
        
        int wordCount = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                wordCount++;
            }
        }
        
    
        String[] result = new String[wordCount];
        int wordIndex = 0;
        int startIndex = 0;
        
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                result[wordIndex] = str.substring(startIndex, i);
                wordIndex++;
                startIndex = i + 1;
            }
        }
        
        
        result[wordIndex] = str.substring(startIndex);
        
        return result;
    }
   
    public static String Split(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = 0;
        StringBuilder result = new StringBuilder();

        for (end = 0; end < s.length(); end++) {
            if (s.charAt(end) == ' ' || end == s.length() - 1) {
                if (end > start) {
                    
                    result.append(s.substring(start, end));
                    
                    if (end < s.length() - 1) {
                        result.append(", ");
                    }
                }
                start = end + 1;
            }
        }

        
        if (start < s.length()) {
            result.append(s.substring(start));
        }

        return result.toString();
    }
    
    public static String shift(String s, int n) {
        if (s == null || s.isEmpty() || n < 0 || n >= s.length()) {
            
            return s;
        }

        int length = s.length();
        char[] result = new char[length];

       
        int index = 0;
        for (int i = n; i < length; i++) {
            result[index++] = s.charAt(i);
        }

      
        for (int i = 0; i < n; i++) {
            result[index++] = s.charAt(i);
        }

        return new String(result);
    }
    public static String Shift(String input, int position) {
    	
    	if (position < 0) {
            System.out.println("Warning: Negative shift value entered. Returning the original string.");
            return input; 
        }
        char chars[] = input.toCharArray();
        int length = input.length();
        position = position % length; 
        position = length - position; 

        reverseForShift(chars, 0, position - 1);    
        reverseForShift(chars, position, length - 1);    
        reverseForShift(chars, 0, length - 1);    

        return new String(chars);
    }

    public static void reverseForShift(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
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
        case "7":
        	Scanner rString = new Scanner(System.in);
           System.out.println("Enter main string:");
           String mainString = rString.nextLine();
           System.out.println("Enter the substring to replace:");
           String toReplace = rString.nextLine();
           System.out.println("Enter string to replace with:");
           String replaceWith = rString.nextLine();
           modifyString( mainString,  toReplace,  replaceWith);
            break;
//
        case "8":
        	Scanner input = new Scanner(System.in);
            System.out.println("Enter string to splice: ");
            String str = input.nextLine();
            
            System.out.println("Give the starting index: ");
            int start = input.nextInt();
            
            System.out.println("How many characters to splice : ");
            int length = input.nextInt();
            
            System.out.println("Spliced string :" + Splice(str, start, length));
            break;
//
        case "9":
        	Scanner scanner = new Scanner(System.in);

            
            System.out.println("Enter the string to be split:");
            String words = scanner.nextLine();

            

          
            System.out.println("Result:" + Split(words));
            
            break;

        case "10":       
            
            Scanner shiftop = new Scanner(System.in);
            System.out.println("Enter the string to be shifted:");
            String string = shiftop.nextLine();

            System.out.println("Enter the number of characters to shift:");
            int shiftCount = shiftop.nextInt();

          
            String result = Shift(string, shiftCount);

            
            System.out.println("Shifted result:");
            System.out.println(result);
            break;

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
            System.out.println("7. Replace a substring");
            System.out.println("8. Splice");
            System.out.println("9. Split");
            System.out.println("10. Shift");
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

