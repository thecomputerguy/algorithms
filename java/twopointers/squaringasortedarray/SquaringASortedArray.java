package twopointers.squaringasortedarray;

import java.util.Arrays;

public class SquaringASortedArray {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int index = arr.length - 1;
        while (left <= right) {
            int leftSquared = arr[left] * arr[left];
            int rightSquared = arr[right] * arr[right];
            if (leftSquared >= rightSquared) {
                squares[index] = leftSquared;
                left++;
            } else {
                squares[index] = rightSquared;
                right--;
            }
            index--;
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -3, -1, 0, 1, 2 };
        int[] result = makeSquares(arr);
        System.out.println(Arrays.toString(result));
    }

}