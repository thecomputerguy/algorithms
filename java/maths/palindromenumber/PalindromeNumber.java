package maths.palindromenumber;

import java.util.Scanner;

public class PalindromeNumber {

    public boolean isPalindrome(int num){

        if(num == 0) return Boolean.TRUE;
        
        if(num < 0 || (num % 10) == 0){
            return Boolean.FALSE;
        }
        
        //reverse half of the interger and compare it against the other half.
        int reverseInt = 0;
        while(num > reverseInt){
            int last = num % 10;
            num = num / 10;
            reverseInt = (reverseInt * 10) + last;
        }

        if(num == reverseInt || num == reverseInt/10){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
    
    public static void main(String[] args) {
        PalindromeNumber palindrome = new PalindromeNumber();
        try(Scanner scan = new Scanner(System.in)){
            System.out.println("Enter a number: ");
            int num = scan.nextInt();
            boolean result = palindrome.isPalindrome(num);
            System.out.println(String.format("is %s a palindrome? %s", num, result));
            
        }
    }
}