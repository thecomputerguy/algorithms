package twopointers.dutchnationalflag;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int low = 0, high = arr.length - 1;
        for (int index = 0; index <= high;) {
            if (arr[index] == 0) {
                swap(arr, index, low);
                index++;
                low++;

            } else if (arr[index] == 1) {
                index++;
            } else {
                swap(arr, index, high);
                high--;
            }
        }

    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[] { 2, 2, 0, 1, 2, 0 };
        sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}