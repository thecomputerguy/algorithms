package arrays.pairwithtargetsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairWithTargetSumAlternateSolution {

    public static int[] pairWithTargetSumAlternateSolution(int[] arr, int targetSum) {
        if (arr == null || arr.length == 0 || targetSum <= 0)
            return new int[] { -1, -1 };
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < arr.length; index++) {
            int otherElement = targetSum - arr[index];
            if (map.containsKey(otherElement)) {
                return new int[] { Math.min(index, map.get(otherElement)), Math.max(index, map.get(otherElement)) };
            } else {
                map.put(arr[index], index);
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 11, 17, 39 };
        int targetSum = 50;
        int[] result = pairWithTargetSumAlternateSolution(arr, targetSum);
        System.out.println(Arrays.toString(result));
    }
}