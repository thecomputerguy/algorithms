package arrays.singlenumber;

public class SingleNumberUsingXOROperator {
    
    public int findSingleNumber(int[] data){
        
        if(data == null || data.length == 0) return -1;
        
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result ^= data[i];     
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("single number solution.");
        SingleNumberUsingXOROperator singleNumberUsingXOROperator = new SingleNumberUsingXOROperator();
        int[] data = new int[]{4, 1, 2, 2, 1};
        int number = singleNumberUsingXOROperator.findSingleNumber(data);
        System.out.println("single number is " + number);
    }
}