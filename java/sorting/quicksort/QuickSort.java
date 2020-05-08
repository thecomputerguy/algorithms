package sorting.quicksort;

import java.util.Scanner;

public class QuickSort {
    
    public void sort(int data[]){

        quickSort(data, 0, data.length-1);
    }

    private void quickSort(int data[], int leftStart, int rightEnd){

        if(leftStart >= rightEnd){
            
            return;
        }

        int mid = (leftStart + rightEnd) / 2;
        int pivot = data[mid];
        int index = partition(data, leftStart, rightEnd, pivot);
        quickSort(data, leftStart, index-1);
        quickSort(data, index, rightEnd);
    }

    private int partition(int data[], int left, int right, int pivot){

        while(left <= right){

            while(data[left] < pivot){

                left++;
            }

            while(data[right] > pivot){

                right--;
            }

         
            if(left <= right){
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }
        
        return left;

    }

    public static void main(String[] args) {
        
        QuickSort quickSort = new QuickSort();
        try(Scanner scan = new Scanner(System.in)){

            System.out.println("Enter the number of elements you wish to add to array.");
            int num = scan.nextInt();
            int[] data = new int[num];
            int i = 0;
            while(i < num){

                System.out.println("Enter the next number:");
                int nextNum = scan.nextInt();
                data[i] = nextNum;
                i++;
            }

            System.out.println("Data before sorting ");
            int j = 0;
            while(j < num){
                System.out.print(data[j] + " ");
                j++;
            }

            System.out.println();
            System.out.println("Sorting data using Quick sort:");
            quickSort.sort(data);

            System.out.println("Data after sorting ");
            
            int k = 0;
            while(k < num){
                System.out.print(data[k] + " ");
                k++;
            }
        }
    }
}