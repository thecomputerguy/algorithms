package searching.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveBinarySearch {
    
    public int search(int element, int[] data){

        int index = search(element, data, 0, data.length);

        return index;
    }

    private int search(int element, int[] data, int left, int right){

        if(left > right){

            return -1;
        }

        int mid = (right + left) / 2;
        if(element == data[mid]){

            return mid;
        }else if(element < data[mid]){
            
            return search(element, data, left, mid-1); 
        }else if(element > data[mid]){

            return search(element, data, mid+1, right);
        }

        return -1;
    }


    public static void main(String[] args) {
    
        RecursiveBinarySearch binarySearch = new RecursiveBinarySearch();
        try(Scanner scan = new Scanner(System.in)){
            System.out.println("Enter the number of elements you want to add in the array.");
            int numberOfElements = scan.nextInt();
            int[] data = new int[numberOfElements];
            int i = 0;
            while(i < numberOfElements){
                System.out.println("Enter the next element:");
                int nextInt = scan.nextInt();
                data[i] = nextInt;
                i++;
            }
            System.out.println("Successfully populated the array!");
            System.out.println("Sorting array to apply binary search!");
            Arrays.sort(data);
            System.out.println("Enter the element to search:");
            int element = scan.nextInt();
            int index  = binarySearch.search(element, data);
            
            if(index == -1){
                System.out.println("Element does not exist in the array!");
                return;
            }

            System.out.println("Found at position " + index);
        }
        
    }
}