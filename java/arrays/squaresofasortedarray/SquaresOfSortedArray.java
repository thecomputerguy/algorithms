package arrays.squaresofasortedarray;

public class SquaresOfSortedArray {
    
    public int[] sortedSquare(int data[]){

        if(data == null || data.length == 0) return data;
        
        int left = 0;
        int right = data.length - 1;

        while(left <= right){
            if(Math.abs(data[left]) <= Math.abs(data[right])){
                data[left] = data[left] * data[left];
                left++;
            }else{
                data[right] = data[right] * data[right];
                right++;
            }
        }

        return data;
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