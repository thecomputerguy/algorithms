package dynamicprogramming.staircaseproblem;

import java.util.Scanner;

public class StairCaseProblem {
    
    public static long countPaths(int steps){

        if(steps < 0){

            return 0;
        }else if(steps <= 1){

            return 1;
        }

        long[] paths = new long[steps+1];
        
        //If 0 steps remaining, then exactly 1 path i.e stay right where you are.
        paths[0] = 1;
        //If we have 1 step then exactly 1 path i.e take 1 step.
        paths[1] = 1;
        //If we have 2 steps then exaclty 2 paths i.e either take 2 (1 and 1 steps) or take 2 steps directly.
        paths[2] = 2;
        
        for(int i = 3; i <= steps; i++){

            //paths[i] will be the addition of 1 step taken or 2 step taken or 3 step taken.
            paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3];
        }

        return paths[steps];
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