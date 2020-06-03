package arrays.mountainarray;

public class MountainArrayUsingBinarySearch {
    
    public int search(int data[]){
        if(data == null || data.length == 0) return Integer.MIN_VALUE;
        int left = 0;
        int right = data.length-1;
        while(left < right){
            int mid = left + ((right+left)/2);

            if(data[mid] > data[mid+1]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return data[left];
    }

    public static void main(String[] args) {
        MountainArrayUsingBinarySearch mountainArray = new MountainArrayUsingBinarySearch();
        int[] data = new int[]{0,2,1,0};
        int element = mountainArray.search(data);
        System.out.println(element + " ");
    }
}