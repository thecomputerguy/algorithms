package twopointers.quadrupletssumtotarget;

import java.util.*;

public class QuadrupletsSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return quadruplets;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                findPair(arr, i, j, target, quadruplets);
            }
        }
        return quadruplets;
    }

    public static void findPair(int[] arr, int first, int second, int target, List<List<Integer>> quadruplets) {

        int left = second + 1;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if (sum == target) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++;
                while (left < right && arr[right] == arr[right + 1])
                    right--;

            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 1, 2, -1, 1, -3 };
        int target = 1;
        List<List<Integer>> result = searchQuadruplets(arr, target);
        for (List<Integer> list : result) {
            System.out.print(Arrays.toString(list.toArray()) + " ");
        }

        System.out.println();
        int[] arr1 = new int[] { 2, 0, -1, 1, -2, 2 };
        int target1 = 2;
        List<List<Integer>> result1 = searchQuadruplets(arr1, target1);
        for (List<Integer> list : result1) {
            System.out.print(Arrays.toString(list.toArray()) + " ");
        }
    }
}