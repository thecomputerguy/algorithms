package arrays.duplicatenumber;

public class DuplicateNumber {
    
    public int findDuplicate(int[] data){

        if(data == null || data.length == 0) return Integer.MIN_VALUE;
        int slow = data[0];
        int fast = data[0];
        slow = data[slow];
        fast = data[data[fast]];

        while(slow != fast){
            slow = data[slow];
            fast = data[data[fast]];
        }

        int firstPointer = data[0];
        int secondPointer = slow;

        while(firstPointer != secondPointer){
            firstPointer = data[firstPointer];
            secondPointer = data[secondPointer];
        }

        return firstPointer;
    }

    public static void main(String[] args) {
        
        DuplicateNumber duplicateNumber = new DuplicateNumber();
        System.out.println("Duplicate number using floyd's hare and tortoise algorithm.");
        int[] data = new int[]{1,3,4,2,2};
        int num = duplicateNumber.findDuplicate(data);
        System.out.println("Duplicate number is : " + num);

    }
}