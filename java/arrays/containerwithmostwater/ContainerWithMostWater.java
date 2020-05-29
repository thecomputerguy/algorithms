package arrays.containerwithmostwater;

public class ContainerWithMostWater {
    
    public int maxArea(int[] height){

        //Two pointer approach to solve the problem.
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        
        while(left < right){
           int currentArea = 0;
            if(height[left] < height[right]){
                currentArea = height[left] * (right - left);
                result = Math.max(currentArea, result);
                left++;
            }else{
                currentArea = height[right] * (right - left);
                result = Math.max(currentArea, result);
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println("Container with most water solution.");
        int[] data = new int[]{1,8,6,2,5,4,8,3,7};
        int area = containerWithMostWater.maxArea(data);
        System.out.println("Container with most water has an area of " + area);
    }
}