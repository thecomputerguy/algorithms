package slidingwindow.averageofsubarrayofsizek;

import java.util.Arrays;

public class AverageOfSubArrayOfSizeK {
    
    private static double[] averageOfSubarray(int data[], int K){
        
        int windowStart = 0;
        double windowSum = 0;
        double[] averages = new double[data.length - K + 1];
        for (int windowEnd = 0; windowEnd < data.length; windowEnd++) {
            
            windowSum += data[windowEnd]; //sum for current window
            
            if(windowEnd >= K-1){ //check if we have reached window length
                averages[windowStart] = windowSum / K; //calculate average and save it
                windowSum -= data[windowStart]; //subtract value of element at windowStart because we will move to next element for next subarray window 
                windowStart++; //move away from the starting element of the window to start a new window
            }
        }
        return averages;
    }

    private static void printAverages(double[] averages){
        System.out.println(Arrays.toString(averages));
    }
    public static void main(String[] args) {
        int[] data = new int[]{1,3,2,6,-1,4,1,8,2};
        int K = 5;
        double[] averages = AverageOfSubArrayOfSizeK.averageOfSubarray(data, K);
        printAverages(averages);
    }
}