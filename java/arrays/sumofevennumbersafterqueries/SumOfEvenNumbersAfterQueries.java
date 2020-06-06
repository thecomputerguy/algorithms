package arrays.sumofevennumbersafterqueries;

import java.util.Arrays;
import java.util.function.Consumer;

public class SumOfEvenNumbersAfterQueries {
    
    public int[] sumOfEvensAfterQueries(int[] data, int[][] queries){
 
        if(data == null || data.length == 0 || queries == null || queries.length == 0) return data;
        int[] result = new int[queries.length];
        //Calculate initial sum of even numbers...
        int sum = initialSum(data);
        System.out.println("Initial sum is " + sum);
        for (int i = 0; i < queries.length; i++) {
            
            int val = queries[i][0];
            int index = queries[i][1];

            if((data[index] % 2) == 0) sum = sum - data[index];

            data[index] += val; 
            
            if((data[index] % 2) == 0) sum = sum + data[index];
            
            //ith query result.
            result[i] = sum;
        }

        return result;
    }

    private int initialSum(int[] data){
        
        return Arrays.stream(data).filter( e -> e % 2 == 0).sum();
    }

    public static void main(String[] args) {

        System.out.println("Sum of even numbers after queries.");
        SumOfEvenNumbersAfterQueries sum = new SumOfEvenNumbersAfterQueries();
        int[] data = new int[]{1,2,3,4};
        int[][] queries = new int[][]{{1,0},{-3,1},{-4,0},{2,3}}; 
        int[] result = sum.sumOfEvensAfterQueries(data, queries);
        Consumer<Integer> consumer = System.out::println;
        Arrays.stream(result).forEach(consumer::accept);
    }
}