package twopointers.tripletwithsmallersumthantarget;

import java.util.*;

public class TripletWithSmallerSumThanTarget {

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int index = 0; index < arr.length - 2; index++) {
            count += findPair(arr, target - arr[index], index + 1);
        }
        return count;
    }

    public static int findPair(int[] arr, int target, int left) {
        int right = arr.length - 1;
        int count = 0;
        while (left < right) {

            if (arr[left] + arr[right] < target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] arr = new int[] { -1, 4, 2, 1, 3 };
        int target = 5;
        int result = searchTriplets(arr, target);
        System.out.println(result);

        int[] arr1 = new int[] { -1, 0, 2, 3 };
        int target1 = 3;
        int result1 = searchTriplets(arr1, target1);
        System.out.println(result1);
    }
}