package dynamicprogramming.fibonacci;

import java.util.Scanner;

public class Fibonacci {
    
    private static long dpFib(int num){

        long[] dpTable = new long[num+1];
        dpTable[0] = 0;
        dpTable[1] = 1;

        System.out.print(0 + " ");
        System.out.print(1 + " ");
        int i = 2;
        while(i < dpTable.length){

            dpTable[i] = dpTable[i-1] + dpTable[i-2];
            System.out.print(dpTable[i] + " ");
            i++;
        }

        //Add a blank line.
        System.out.println();

        //Final result can be given by dpTable[i-1] or dpTable[num];
        return dpTable[i-1];
    }


    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)){
            
            System.out.println("Please enter the number to calculate fibonacci series of the number.");
            int num = scan.nextInt();
            System.out.println("Read " + num);
            
            System.out.println("Fibonacci number of " + num + " is " + dpFib(num));
        }
    }
}