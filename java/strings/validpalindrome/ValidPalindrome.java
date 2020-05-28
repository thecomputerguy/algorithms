package strings.validpalindrome;

public class ValidPalindrome {
    
    public boolean valid(String input){

        if(input == null || input.length() == 0){
            return true;
        }

        input = input.toLowerCase();
        int left = 0;
        int right = input.length()-1;

        while(left <= right){
            if(!Character.isDigit(input.charAt(left)) && !Character.isLetter(input.charAt(left))){
                left++;
                continue;
            }else if(!Character.isDigit(input.charAt(right)) && !Character.isLetter(input.charAt(right))){
                right--;
                continue;
            }else if(input.charAt(left) != input.charAt(right)){
                return false;
            }
            left++;
            right--;
        }


        return true;
    }

    public boolean betterSolution(String input){

        if(input == null || input.length() == 0) return true;

        StringBuilder prunedString = new StringBuilder();
        for(int i =0; i < input.length(); i++){
            if(Character.isDigit(input.charAt(i)) || Character.isLetter(input.charAt(i))){
                prunedString.append(input.charAt(i));
            }
        }

        String data = prunedString.toString().toLowerCase();
        int left = 0;
        int right = data.length() - 1;

        while(left <= right){
            if(data.charAt(left) != data.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println("Palindrome with alphanumeric characters only.");
        boolean result1 = validPalindrome.valid("learning is essential");
        boolean result2 = validPalindrome.valid("race car");
        boolean result3 = validPalindrome.valid("9Ma dam9");
        System.out.println("First : " + result1);
        System.out.println("second : " + result2);
        System.out.println("Third : " + result3);

        System.out.println();
        System.out.println("Better solution.");
        boolean result4 = validPalindrome.betterSolution("learning is essential");
        boolean result5 = validPalindrome.betterSolution("race car");
        boolean result6 = validPalindrome.betterSolution("9Ma dam9");
        System.out.println("First : " + result4);
        System.out.println("second : " + result5);
        System.out.println("Third : " + result6);
    }
}