package arrays.squaresofasortedarray;

public class SquaresOfSortedArray {
    
    public int[] sortedSquare(int data[]){

        if(data == null || data.length == 0) return data;
        
        int negativePointer = 0;
        int positivePointer = 0;
        int N = data.length;
        int[] sortedSquares = new int[data.length];

        //skip over all the negative elements in the beginning of the array.
        while(positivePointer < N && data[positivePointer] < 0){
            positivePointer++;
        }

        //point to the biggest negative element.
        negativePointer = positivePointer - 1;
        int counter = 0;
        while(negativePointer >= 0 && positivePointer < N){
            if(data[negativePointer] * data[negativePointer] < data[positivePointer] * data[positivePointer]){
                sortedSquares[counter] = data[negativePointer] * data[negativePointer];
                negativePointer--;
                counter++;
            }else{
                sortedSquares[counter] = data[positivePointer] * data[positivePointer];
                positivePointer++;
                counter++;
            }
        }

        while(negativePointer >= 0){
            sortedSquares[counter] = data[negativePointer] * data[negativePointer];
            negativePointer--;
            counter++;
        }

        while(positivePointer < N){
            sortedSquares[counter] = data[positivePointer] * data[positivePointer];
            positivePointer++;
            counter++;
        }
      

        return sortedSquares;
    }

    public void print(int[] data){
        
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " "); 
        }
    }

    public static void main(String[] args) {

        SquaresOfSortedArray sortedArray = new SquaresOfSortedArray();
        int[] data = new int[]{-4,-1,0,3,10};
        System.out.println("Data before square");
        sortedArray.print(data);
        int[] squaredAndSortedArray  = sortedArray.sortedSquare(data);
        System.out.println("Data after square!");
        sortedArray.print(squaredAndSortedArray);
    }
}