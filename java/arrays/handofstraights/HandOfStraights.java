package arrays.handofstraights;

import java.util.TreeMap;

/**
 * Hand of straights problem. Given an array of cards, return true if the given cards can be grouped in the given 
 * group size. Also, the cards in any group needs to be consecutive.
 */

public class HandOfStraights {
    
    public boolean solve(int data[], int groupSize){

        if(data == null || data.length == 0 || groupSize < 1) return false;
        TreeMap<Integer, Integer> countsMap = new TreeMap<>();
        //Go through each element and add the element to count map with it's count.
        for (int i = 0; i < data.length; i++) {
            
            if(countsMap.containsKey(data[i])){
                countsMap.replace(data[i], countsMap.get(data[i]) + 1);
            }else{
                countsMap.put(data[i], 1);
            }
            
        }

        while(countsMap.size() > 0){
            int key = countsMap.firstKey();
            for (int i = key; i < key + groupSize; i++) {
                
                if(!countsMap.containsKey(i)) return false;
                
                if(countsMap.get(i) == 1){
                    countsMap.remove(i);
                }else{
                    countsMap.replace(i, countsMap.get(i) - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        HandOfStraights handOfStraights = new HandOfStraights();
        System.out.println("Hand of straights problem.");
        int[] data = new int[]{1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        boolean result = handOfStraights.solve(data, groupSize);
        System.out.println("can arrange cards in group of 3 ? " + result);
    }
}