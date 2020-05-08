package searching.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class IterativeBinarySearch {

    public int search(int element, int[] data){

        int left = 0;
        int right = data.length;

        while(left <= right){

        int mid = (right+left)/2;

        if(element == data[mid]){

            return mid;
        }else if(element < data[mid]){

            right = mid - 1;
        }else if(element > data[mid]){

            left = mid+1;
        }

    }

        return -1;
    }
    
    public static void main(String[] args) {
        
        IterativeBinarySearch binarySearch = new IterativeBinarySearch();
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