package arrays.makeanagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeAnagrams {

    private static int NUM_CHAR = 26;

    private static int delta(int[] charCount1, int[] charCount2){
        
        if(charCount1.length != charCount2.length){

            throw new IllegalStateException("Two arrays are of different length.");
        }

        int delta = 0;

        for(int i = 0; i < charCount1.length; i++){

            int difference = Math.abs(charCount1[i] - charCount2[i]);
            delta += difference;
        }

        return delta;
    }

    private static int[] charCount(String data){

        int[] countArray = new int[NUM_CHAR];
        int charCode = (int) 'a';
        for(int i = 0; i < data.length(); i++){
            char c = data.charAt(i);
            int code = c - charCode;
            countArray[code]++; 
        }
        
        return countArray;
    }

    public static int numOfCharToRemove(String string1, String string2){

        //char count for first string.
        int[] charCount1 = charCount(string1);
        int[] charCount2 = charCount(string2);
        int delta = delta(charCount1, charCount2);
        return delta;
    }

    public static void main(String[] args) throws IOException {
        
        System.out.println("Enter two strings to get the number of characters that you will have to remove to make them anagarams.");

        try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter the first string:");
            String string1  = buffer.readLine();
            System.out.println("Enter the second string:");
            String string2 = buffer.readLine();
            System.out.println("Number of characters to remove: " + numOfCharToRemove(string1, string2));       
    
        }
    }
}