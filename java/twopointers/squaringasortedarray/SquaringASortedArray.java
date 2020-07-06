package twopointers.squaringasortedarray;

import java.util.Arrays;

public class SquaringASortedArray {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int index = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare >= rightSquare) {
                squares[index] = leftSquare;
                left++;
            } else {
                squares[index] = rightSquare;
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