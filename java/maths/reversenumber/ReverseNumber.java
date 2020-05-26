package maths.reversenumber;

import java.util.Scanner;

public class ReverseNumber {
    
    public int reverse(int num){

        int reversed = 0;
        int pop;
        while(num > 0){

            pop = num % 10;
            if(reversed > Integer.MAX_VALUE / 10 || reversed == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if(reversed < Integer.MIN_VALUE / 10 || reversed == Integer.MIN_VALUE / 10 && pop < -8) return 0;

            num /= 10;
            reversed = (reversed *10) + pop;
        }

        return reversed;
    }

    public static void main(String[] args) {
        
        System.out.println("Enter the number to reverse it.");
        ReverseNumber reverser = new ReverseNumber();
        try(Scanner scan = new Scanner(System.in)){
            int num = scan.nextInt();
            int reversed = reverser.reverse(num);
            System.out.println("Reversed Number : " + reversed);
        }
    }
}