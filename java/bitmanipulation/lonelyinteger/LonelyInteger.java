package bitmanipulation.lonelyinteger;

import java.util.Scanner;

public class LonelyInteger {
    
    public static int solve(int data[]){

        int result = 0;
        for (int i : data) {
            
            result ^= i;
        }

        return result;
    }

    public static void main(String[] args) {
        
        System.out.println("Enter the elements in the array.");
        
        try(Scanner scan = new Scanner(System.in)){
            System.out.println("Enter the number of values you wish to add to array:");
            int numOfValues = scan.nextInt();
            int[] data = new int[numOfValues];
            int i = 0; 
            while(i < numOfValues){
                
                System.out.println("Enter the next number: ");
                int number = scan.nextInt();
                data[i] = number;
                i++;
            }

            System.out.println("Lonely integer is: " + solve(data)); 

        }
    }
}