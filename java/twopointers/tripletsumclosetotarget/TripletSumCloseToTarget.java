package twopointers.tripletsumclosetotarget;

import java.util.*;

public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 3)
            return -1;
        int smallestDiff = Integer.MAX_VALUE;
        for (int index = 0; index < arr.length - 2; index++) {
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int targetDiff = targetSum - arr[index] - arr[left] - arr[right];
                if (targetDiff == 0) {
                    return targetSum - targetDiff;
                }
                if (Math.abs(targetDiff) < Math.abs(smallestDiff)
                        || Math.abs(targetDiff) == Math.abs(smallestDiff) && targetDiff > smallestDiff)
                    smallestDiff = targetDiff;

                if (targetDiff > 0) {
                    left++;
                } else {
                    right--;
                }

            }

        }
        return targetSum - smallestDiff;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 1, 1 };
        int targetSum = 100;
        int result = searchTriplet(arr, targetSum);
        System.out.println(result);

        int[] arr1 = new int[] { -3, -1, 1, 2 };
        int targetSum1 = 1;
        int result1 = searchTriplet(arr1, targetSum1);
        System.out.println(result1);
    }

}