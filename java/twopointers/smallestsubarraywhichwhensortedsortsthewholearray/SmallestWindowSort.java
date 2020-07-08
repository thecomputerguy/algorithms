package twopointers.smallestsubarraywhichwhensortedsortsthewholearray;

public class SmallestWindowSort {

    public static int sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        // Look for the out of order element from the beginning.
        int left = 1;
        while (left < arr.length && arr[left - 1] < arr[left])
            left++;
        if (left == arr.length)
            return 0;

        // look for the out of order element from the end.
        int right = arr.length - 2;
        while (right >= 0 && arr[right] < arr[right + 1])
            right--;
        if (right < 0)
            return 0;

        // Find the min and max in the subarray
        int subarrayMax = Integer.MIN_VALUE;
        int subarrayMin = Integer.MAX_VALUE;
        for (int index = left; index <= right; index++) {
            subarrayMax = Math.max(subarrayMax, arr[index]);
            subarrayMin = Math.min(subarrayMin, arr[index]);
        }

        // expand the beginning of window till the element at left-1 is greater than
        // subarrayMin
        while (left > 0 && arr[left - 1] > subarrayMin)
            left--;

        // expand the ending of the window till the element at the right is smaller than
        // subarrayMax
        while (right < arr.length - 1 && arr[right + 1] < subarrayMax)
            right++;

        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 5, 3, 7, 10, 9, 12 };
        int result = sort(arr);
        System.out.println(result);

        int[] arr1 = new int[] { 1, 3, 2, 0, -1, 7, 10 };
        int result1 = sort(arr1);
        System.out.println(result1);

        int[] arr2 = new int[] { 1, 2, 3 };
        int result2 = sort(arr2);
        System.out.println(result2);
    }

}