package dynamicprogramming.staircaseproblemspaceoptimized;

import java.util.Scanner;

public class StairCaseProblemSpaceOptimized {
    
    public static long countPaths(int steps){

        if(steps < 0){
            return 0;
        }else if(steps <= 1){
            return 1;
        }

        long[] paths = new long[3];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;

        for(int i = 3; i <= steps; i++){

            //Because we care about only last three results, so no need to create an array of length steps + 1.
            //At any given time we will hold only last three paths.
            long pathCount = paths[2] + paths[1] + paths[0];
        
            paths[0] = paths[1];
            paths[1] = paths[2];
            paths[2] = pathCount;
        }

        return paths[2];
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