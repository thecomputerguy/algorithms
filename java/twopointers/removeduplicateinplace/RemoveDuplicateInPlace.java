package twopointers.removeduplicateinplace;

public class RemoveDuplicateInPlace {

    public static int remove(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int nextNonDuplicate = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 2, 2, 11 };
        int result = remove(arr);
        System.out.println(result);
    }

}