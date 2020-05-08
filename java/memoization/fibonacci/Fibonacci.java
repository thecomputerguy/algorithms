package memoization.fibonacci;

import java.util.Scanner;

public class Fibonacci {
    
    private static long memoFib(int num){

        long[] cache = new long[num+1];
        int i = 0;
        while(i <= num){
            cache[i] = -1;
            i++;
        }
        
        return memoFib(num, cache);
    }

    private static long memoFib(int num, long[] cache){

        //If the num is already in cache, then return the cached result.
        if(cache[num] != -1){

            return cache[num];
        }
        
        //If num is 0 or 1 return num.
        if(num <= 1){
            
            return num; 
        }

        //Number was not in the cache so compute the fib for that, add it to cache and finally return.
        long n  = memoFib(num-1, cache) + memoFib(num-2, cache);
        cache[num] = n;
        return n;
    }

    public static void main(String[] args) {
        
        
        try(Scanner scan = new Scanner(System.in)){
            
            System.out.println("Please enter the number to calculate fibonacci series of the number.");
            int num = scan.nextInt();
            System.out.println("Read " + num);
            System.out.println("Fibonacci number of " + num + " is " + memoFib(num));
        }
    }
}