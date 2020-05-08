package searching.linearsearch;
import java.util.Scanner;

public class LinearSearch {

    private int search(int element, int[] data){

        for(int i = 0; i < data.length; i++){

            if(data[i] == element){

                return i;
            }
        }


        return -1;
    }

    public static void main(String[] args) {

        LinearSearch linearSearch = new LinearSearch();
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the number of elements you want to add in the array.");
            int numberOfElements = scan.nextInt();
            int[] data = new int[numberOfElements];
            int i = 0;
            while (i < numberOfElements) {
                System.out.println("Enter the next element:");
                int nextInt = scan.nextInt();
                data[i] = nextInt;
                i++;
            }
            System.out.println("Successfully populated the array!");
            //System.out.println("Sorting array to apply binary search!");
            //Arrays.sort(data);
            System.out.println("Enter the element to search:");
            int element = scan.nextInt();
            int index = linearSearch.search(element, data);

            if (index == -1) {
                System.out.println("Element does not exist in the array!");
                return;
            }

            System.out.println("Found at position " + index);
        }
    }
}