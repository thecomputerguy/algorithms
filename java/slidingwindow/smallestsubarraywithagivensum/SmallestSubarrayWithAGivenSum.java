package slidingwindow.smallestsubarraywithagivensum;

public class SmallestSubarrayWithAGivenSum {

    public static int findMinSubArray(int S, int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int windowSum = 0;
        int winStart = 0;
        int winLength = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= S) {
                winLength = Math.min(winLength, windowEnd - winStart + 1);
                windowSum -= arr[winStart];
                winStart++;
            }
        }
        return winLength == Integer.MAX_VALUE ? 0 : winLength;
    }

    public static void main(String[] args) {
        int S = 8;
        int[] arr = new int[] { 3, 4, 1, 1, 6 };
        int result = findMinSubArray(S, arr);
        System.out.println("Min length of subarray that has sum greater than or equal to S is " + result);
    }
}