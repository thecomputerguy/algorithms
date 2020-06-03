package strings.reverseonlyletters;

import java.util.Stack;

public class ReverseOnlyLettersUsingStack {
    

    public String reverse(String data){

        if(data == null || data.isEmpty()) return data;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < data.length(); i++){
           if(Character.isLetter(data.charAt(i))) stack.add(data.charAt(i));
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < data.length(); i++){
            if(Character.isLetter(data.charAt(i))){
                builder.append(stack.pop());
            }else{
                builder.append(data.charAt(i));
            }
        }

        return builder.toString();
    }


    public static void main(String[] args) {

        ReverseOnlyLettersUsingStack reverseOnlyLetters = new ReverseOnlyLettersUsingStack();
        String data = "a-jb-jan-van-rafd";
        String reversed = reverseOnlyLetters.reverse(data);
        System.out.println(reversed);
    }
}