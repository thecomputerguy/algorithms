package arrays.arraypartition1;

import java.util.Arrays;

public class ArrayPartition1 {
    
    public int arrayPairSum(int[] data){
        if(data == null || data.length == 0) return 0;
        
        Arrays.sort(data);
        int sum = 0;
        
        for (int i = 0; i < data.length-1; i = i+2) {
            sum += Math.min(data[i], data[i+1]);  
        }

        return sum;
    }

    public static void main(String[] args) {
        ArrayPartition1 arrayPartition1 = new ArrayPartition1();
        int[] data = new int[]{1, 4, 3, 2};
        int sum = arrayPartition1.arrayPairSum(data);
        System.out.println(sum);
    }
}