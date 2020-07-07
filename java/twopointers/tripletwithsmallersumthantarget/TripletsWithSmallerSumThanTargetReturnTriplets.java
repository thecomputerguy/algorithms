package twopointers.tripletwithsmallersumthantarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSmallerSumThanTargetReturnTriplets {

    public static List<List<Integer>> searchTriplets(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return result;
        Arrays.sort(arr);
        for (int index = 0; index < arr.length - 2; index++) {
            findPair(arr, index, target - arr[index], result);
        }
        return result;
    }

    public static void findPair(int[] arr, int index, int target, List<List<Integer>> result) {
        int left = index + 1;
        int right = arr.length - 1;

        while (left < right) {
            if ((arr[left] + arr[right]) < target) {
                for (int i = right; i > left; i--) {
                    result.add(Arrays.asList(arr[index], arr[left], arr[i]));
                }
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr1 = new int[] { -1, 0, 2, 3 };
        int target1 = 3;
        List<List<Integer>> result1 = searchTriplets(arr1, target1);
        System.out.println("Result of second function call: ");
        for (List<Integer> list : result1) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        int[] arr = new int[] { -1, 4, 2, 1, 3 };
        int target = 5;
        List<List<Integer>> result = searchTriplets(arr, target);
        System.out.println("Result of first function call: ");
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}