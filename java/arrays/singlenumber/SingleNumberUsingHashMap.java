package arrays.singlenumber;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberUsingHashMap {
    
    public int findSingleNumber(int[] data){
        
        if(data == null || data.length == 0) return -1;
        Map<Integer, Integer> holder = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if(holder.containsKey(data[i])){
                holder.put(data[i], holder.get(data[i]) + 1);
            }else{
                holder.put(data[i], 1);
            }
        }

        for (int i = 0; i < data.length; i++) {
            if(holder.get(data[i]) == 1){
                return data[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Single number solution.");
        SingleNumberUsingHashMap singleNumber = new SingleNumberUsingHashMap();
        int[] data = new int[]{4, 1, 2, 1 , 2};
        int number = singleNumber.findSingleNumber(data);
        System.out.println("Single Number " + number);
    }
}