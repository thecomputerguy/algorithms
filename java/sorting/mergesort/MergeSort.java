package sorting.mergesort;

import java.util.Scanner;

public class MergeSort {
    

    public void sort(int[] data){

        int left = 0;
        int right = data.length-1;
        mergeSort(data, new int[data.length], left, right);
    }

    private void mergeSort(int data[], int temp[], int leftStart, int rightEnd){

        if(leftStart >= rightEnd){

            return;
        }

        int mid = (leftStart + rightEnd)/2;
        mergeSort(data, temp, leftStart, mid);
        mergeSort(data, temp, mid+1, rightEnd);
        mergeHalves(data, temp, leftStart, rightEnd);
        
    }

    private void mergeHalves(int[] data, int[] temp, int leftStart, int rightEnd){

        int leftEnd = (leftStart + rightEnd)/2;
        int rightStart = leftEnd + 1; 

        int left = leftStart;
        int index = leftStart;
        int right = rightStart;
        while(left <= leftEnd && right <= rightEnd){

            if(data[left] <= data[right]){

                temp[index] = data[left++];
            }else{

                temp[index] = data[right++];
            }

            index++;
        }

        System.arraycopy(data, left, temp, index, leftEnd-left+1);
        System.arraycopy(data, right, temp, index, rightEnd-right+1);
        System.arraycopy(temp, leftStart, data, leftStart, rightEnd-leftStart+1);
    }

    public static void main(String[] args) {
        
        MergeSort mergeSort = new MergeSort();
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
            System.out.println("Sorting data using Merge sort:");
            mergeSort.sort(data);

            System.out.println("Data after sorting ");
            
            int k = 0;
            while(k < num){
                System.out.print(data[k] + " ");
                k++;
            }
        }
    }
}