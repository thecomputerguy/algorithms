package strings.reversestring;
public class ReverseString {
    
    public String reverse(String input){
        
        if(input == null || input.isEmpty() || input.length() == 1){
            return input;
        }

        int left = 0;
        int right = input.length()-1;
        char[] inputArray = input.toCharArray();
        while(left <= right){
            char temp = inputArray[left];
            inputArray[left] = inputArray[right];
            inputArray[right] = temp;
            left++;
            right--;
        }

        return String.valueOf(inputArray);
    }

    public static void main(String[] args) {
        System.out.println("Reverse string solution using two pointer approach.");
        ReverseString reverseString = new ReverseString();
        String rev = reverseString.reverse("Testing");
        System.out.println(rev);
    }
}