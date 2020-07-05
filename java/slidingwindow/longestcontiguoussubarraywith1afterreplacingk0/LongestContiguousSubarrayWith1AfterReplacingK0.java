package slidingwindow.longestcontiguoussubarraywith1afterreplacingk0;

import java.util.HashMap;
import java.util.Map;

public class LongestContiguousSubarrayWith1AfterReplacingK0 {

    public static int findLength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < k)
            return 0;
        int maxLength = 0, maxOne = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1)
                maxOne++;

            if (windowEnd - windowStart + 1 - maxOne > k) {
                if (arr[windowStart] == 1)
                    maxOne--;
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 };
        int k = 3;
        int result = findLength(arr, k);
        System.out.println(result);
    }

}