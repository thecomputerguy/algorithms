package searching.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class IterativeBinarySearch {

    public int search(int target, int[] data){

        if(data == null || data.length == 0) return -1;
        int left = 0;
        int right = data.length-1;


        while(left <= right){

        //To prevent integer overflow in java.
       int mid = left + (right - left) / 2;
       //Alternatively, we can do this way as well
       //int mid = (left + (right - left)) >> 2;

            if(data[mid] == target){

                return mid;
            }
            else if(data[mid] > target){

                right = mid - 1;
            } 
            else{

                left = mid + 1;
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