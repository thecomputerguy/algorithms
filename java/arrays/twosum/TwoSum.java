package arrays.twosum;

import java.util.Scanner;

public class TwoSum {
    
    public int[] solve(int[] data, int sum){
        
        if(data == null || data.length == 0) return data;
        int left = 0;
        int right = data.length-1;
        while(left < right){

            if(data[left] + data[right] > sum){
                //value is getting bigger than the desired sum, so move the right pointer inward.
                right--;
            }else if(data[left] + data[right] < sum){
                //Value is smaller, we need to move left pointer.
                left++;
            }else{
                //data[left] + data[right] == sum
                return new int[]{left, right};
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        
        TwoSum twoSum = new TwoSum();
        try(Scanner scan = new Scanner(System.in)){

            System.out.println("Enter the number of elements you wish to add in the array.");
            int num  = scan.nextInt();
            int[] data = new int[num];
            int j = 0;
            System.out.println("Enter the elements in the array in increasing order.");
            while(j < num){
                System.out.println("Enter the next element:");
                int next = scan.nextInt();
                data[j] = next;
                j++;
            }

            System.out.println("Enter the sum that you wish to find in the array.");
            int sum = scan.nextInt();
            int[] indices = twoSum.solve(data, sum);

            for(int i = 0; i < indices.length; i++){
                //Print the indices.
                System.out.print(indices[i] + " ");
            }
        }
    }
}