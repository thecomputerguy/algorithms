package slidingwindow.averageofsubarrayofsizek; 

class AverageOfSubArrayOfSizeKBruteForce{
    
    private static double[] averageOfSubArrayOfSizeK(int[] data, int K){
        
        double[] averages = new double[data.length - K + 1];
        for (int index = 0; index <= data.length-K; index++) {
            
            int j = index;
            double sum = 0;
            while(j < K+index){
                sum += data[j];
                j++;
            }
            averages[index] = sum / K;
        }
        return averages;
    }

    private static void printAverages(double[] averages){
        for (double average : averages) {
            System.out.print(average + " ");
        }
    }

    public static void main(String args[]){
        int[] data = new int[]{1,3,2,6,-1,4,1,8,2};
        int K = 5;
        double[] averages = AverageOfSubArrayOfSizeKBruteForce.averageOfSubArrayOfSizeK(data, 5);
        AverageOfSubArrayOfSizeKBruteForce.printAverages(averages);
    }
}