package arrays.pairwithtargetsum;

public class PairWithTargetSum {

    public static int[] pairWithTargetSum(int[] arr, int targetSum) {
        if (arr == null || arr.length == 0)
            return new int[] { -1, -1 };
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == targetSum)
                return new int[] { left, right };

            if (sum < targetSum)
                left++;
            else
                right--;

        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 7, 9, 11 };
        int targetSum = 12;
        int[] result = pairWithTargetSum(arr, targetSum);
        System.out.println(result[0] + " " + result[1]);
    }
}