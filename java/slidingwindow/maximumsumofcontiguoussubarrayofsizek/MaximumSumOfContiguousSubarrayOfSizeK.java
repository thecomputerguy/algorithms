package slidingwindow.maximumsumofcontiguoussubarrayofsizek;

public class MaximumSumOfContiguousSubarrayOfSizeK {
    
    private static int maximumSumOfContiguousSubarrayOfSizeK(int[] data, int K){

        int max = Integer.MIN_VALUE;
        int windowSum = 0;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < data.length; windowEnd++) {
            windowSum += data[windowEnd];
            if(windowEnd >= K-1){
                max = Math.max(windowSum, max);
                windowSum -= data[windowStart];
                windowStart++;
            }            
        }

        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,1,5,1,3,2};
        int K = 3;
        int result = maximumSumOfContiguousSubarrayOfSizeK(input, K);
        System.out.println(result);
    }
}