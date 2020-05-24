package arrays.containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContainsDuplicate {
    
    public boolean containsDuplicateWithSorting(int[] data){
        //finds duplicate in O(nlogn)
        if(data == null || data.length == 0) return false;

        Arrays.sort(data);
        for (int i = 0; i < data.length-1; i++) {
            if(data[i] == data[i+1]){
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    public boolean containsDuplicateWithHashSet(int[] data){
        //Finds the duplicate in linear O(n) time.
        Set<Integer> holder = new HashSet<>();
        for (int i = 0; i < data.length; i++) {
            //Iterate through each element of array and check if it exists in the hashset.
            //If it exists, then we have found the duplicate.
            if(holder.contains(data[i])){
                return Boolean.TRUE;
            }else{
                holder.add(data[i]);
            }

        }

        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        
        try(Scanner scan = new Scanner(System.in)){
            System.out.println("Enter the number of elements you want in the array: ");
            int num = scan.nextInt();
            int[] data = new int[num];
            
            for(int i = 0; i < num; i++){
                System.out.println("Enter the next element:");
                int next = scan.nextInt();
                data[i] = next;
            }

            System.out.println("Duplicate with sorting: " + solution.containsDuplicateWithSorting(data));
            System.out.println("Duplicate with hashset: " + solution.containsDuplicateWithHashSet(data));
        }
        
    }
}