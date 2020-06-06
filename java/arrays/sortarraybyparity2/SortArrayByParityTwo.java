package arrays.sortarraybyparity2;

import java.util.Arrays;

public class SortArrayByParityTwo {
    
    public int[] sortArrayByParity(int[] data){

        if(data == null || data.length == 0) return data;
        int even = 0;
        int odd = 1;
        while(odd < data.length && even < data.length){

            while(odd < data.length && data[odd] % 2 == 1){
                odd++;
            }
            while(even < data.length && data[even] % 2 == 0){
                even++;
            }

            if(even < data.length && odd < data.length){
                int temp = data[odd];
                data[odd] = data[even];
                data[even] = temp;
                odd++;
                even++;
            }
        }

        return data;
    }

    public static void main(String[] args) {

        SortArrayByParityTwo sortArrayByParityTwo = new SortArrayByParityTwo();
        int[] data = new int[]{4,2,5,7};
        int[] result  = sortArrayByParityTwo.sortArrayByParity(data);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}