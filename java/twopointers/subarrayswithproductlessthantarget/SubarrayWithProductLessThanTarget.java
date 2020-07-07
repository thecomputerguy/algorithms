package twopointers.subarrayswithproductlessthantarget;

import java.util.*;

public class SubarrayWithProductLessThanTarget {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return subarrays;
        int left = 0;
        int prod = 1;
        for (int right = 0; right < arr.length; right++) {
            prod = arr[right] * prod;
            while (prod >= target && left < arr.length) {
                prod /= arr[left++];
            }
            List<Integer> subarray = new ArrayList<>();
            for (int index = right; index >= left; index--) {
                subarray.add(0, arr[index]);
                subarrays.add(new ArrayList<Integer>(subarray));
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 5, 3, 10 };
        int target = 30;
        List<List<Integer>> result = findSubarrays(arr, target);
        for (List<Integer> list : result) {
            System.out.print(Arrays.toString(list.toArray()) + " ");
        }
        System.out.println();

        int[] arr1 = new int[] { 8, 2, 6, 5 };
        int target1 = 50;
        List<List<Integer>> result1 = findSubarrays(arr1, target1);
        for (List<Integer> list : result1) {
            System.out.print(Arrays.toString(list.toArray()) + " ");
        }
    }
}