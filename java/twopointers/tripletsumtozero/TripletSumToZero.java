package twopointers.tripletsumtozero;

import java.util.*;

public class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int index = 0; index < arr.length - 2; index++) {
            int targetSum = arr[index];
            if (index > 0 && targetSum == arr[index - 1])
                continue;
            pairSum(arr, -targetSum, index + 1, triplets);
        }
        return triplets;
    }

    public static void pairSum(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {

                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++;
                while (left < right && arr[right] == arr[right + 1])
                    right--;
            } else if (targetSum > currentSum) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -5, 2, -1, -2, 3 };
        List<List<Integer>> result = searchTriplets(arr);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}