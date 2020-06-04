package arrays.sortarraybyparity;

public class SortArrayByParity {
    
    public int[] sort(int[] data){
        if(data == null || data.length == 0) return data;
        //use two pointer approach. even pointer in the beginning and odd pointer in the end.
        //swap the odd elements in the beginning with the odd elements in the end.
        int evenPointer = 0;
        int oddPointer = data.length-1;

        while(evenPointer < oddPointer){

            while(data[evenPointer] % 2 == 0){
                evenPointer++;
            }

            while(data[oddPointer] % 2 == 1){
                oddPointer--;
            }

            //Now both the pointers are at the position where we can swap elements so swap.
            swap(data, evenPointer, oddPointer);
            evenPointer++;
            oddPointer--;
        }

        return data;
    }

    private void swap(int[] data, int evenPointer, int oddPointer){
        int temp = data[evenPointer];
        data[evenPointer] = data[oddPointer];
        data[oddPointer] = temp;
    }

    public static void main(String[] args) {
        
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        System.out.println("Sort Array by parity solution.");
        int[] data = new int[]{3, 1, 2, 4};
        int[] sortedArrayByParity = sortArrayByParity.sort(data);
        for (int i = 0; i < sortedArrayByParity.length; i++) {
            System.out.print(sortedArrayByParity[i] + " "); 
        }
    }
}