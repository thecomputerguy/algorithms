package recursion.fibonacci;

import java.util.Scanner;

public class Fibonacci{


    private static int recFib(int num){

        if (num <= 1){

            return num;
        }

        int n = recFib(num-1) + recFib(num-2);
        return n;
    }

    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)){
            
            System.out.println("Please enter the number to calculate fibonacci series of the number.");
            int num = scan.nextInt();
            System.out.println("Read " + num);
            System.out.println("Fibonacci number of " + num + " is " + recFib(num));
        }
    }
}