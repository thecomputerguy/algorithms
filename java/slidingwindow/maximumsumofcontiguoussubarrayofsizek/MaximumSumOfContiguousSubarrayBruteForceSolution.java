package slidingwindow.maximumsumofcontiguoussubarrayofsizek;

public class MaximumSumOfContiguousSubarrayBruteForceSolution {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int index = 0; index <= arr.length - k; index++) {
            int sum = 0;
            // loop to sum up window elements
            for (int j = index; j < index + k; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[] { 2, 1, 5, 1, 3, 2 };
        int result = findMaxSumSubArray(k, arr);
        System.out.println(result);
    }
}