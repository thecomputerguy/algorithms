package memoization.staircaseproblem;

import java.util.Scanner;

public class StairCaseProblem {
    
    public static long countPaths(int steps){

        int arrayLength = 0;
        if(steps < 0){
            arrayLength = 1;
        }else{
            arrayLength = steps + 1;
        }

        return countPaths(steps, new long[arrayLength]);
    }

    private static long countPaths(int steps, long[] memoTable){

        //If the steps are negative then there is no path.
        if(steps < 0){

            return 0;
        }

        if(steps <= 1){

            return 1;
        }

        if(memoTable[steps] != 0){

            return memoTable[steps];
        }

        memoTable[steps] = countPaths(steps-1, memoTable) + countPaths(steps-2, memoTable) + countPaths(steps-3, memoTable);
        return memoTable[steps];
    }

    public static void main(String[] args) {
        
        System.out.println("Stair case problem.");
        System.out.println("Enter the number of steps:");
        try(Scanner scan = new Scanner(System.in)){

            int numOfSteps = scan.nextInt();
            System.out.println("number of paths up " + numOfSteps + " steps if 1 step or 2 step or 3 step are taken at the first leap are: ");
            System.out.println(countPaths(numOfSteps));
        }
    }
}