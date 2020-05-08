package sorting.bubblesort;

import java.util.Scanner;

public class BubbleSort {
    
    private void swap(int index1, int index2, int[] data){

        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public void sort(int[] data){

        boolean sorted = false;
        int lastSorted = data.length - 1;
        while(!sorted){
            
            //Assume sorted.
            sorted = true;
            for (int i = 0; i < lastSorted; i++) {
                
                if(data[i] > data[i+1]){

                    swap(i, i+1, data);
                    sorted = false;
                }
            }

            lastSorted--;
        }

    }

    public static void main(String[] args) {
        
        BubbleSort bubbleSort = new BubbleSort();
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
            System.out.println("Sorting data using bubble sort:");
            bubbleSort.sort(data);

            System.out.println("Data after sorting ");
            
            int k = 0;
            while(k < num){
                System.out.println(data[k] + " ");
                k++;
            }
        }
    }
}