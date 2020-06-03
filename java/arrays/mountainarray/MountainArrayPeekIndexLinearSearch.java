package arrays.mountainarray;

public class MountainArrayPeekIndexLinearSearch {
    
    public int search(int[] data){
        if(data == null || data.length < 3) return Integer.MIN_VALUE;
        
        for(int i = 0; i < data.length - 1; i++){
            if(data[i] > data[i+1]) return data[i];
        }
        
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {

        MountainArrayPeekIndexLinearSearch mountainArray = new MountainArrayPeekIndexLinearSearch();
        int[] data = new int[]{0,2,1,0};
        int element = mountainArray.search(data);
        System.out.println("Mountain element " + element);
    }
}