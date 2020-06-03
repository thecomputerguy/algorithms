package strings.reverseonlyletters;

public class ReverseOnlyLettersUsingTwoPointer {
    
    public String reverse(String data){

        if(data == null || data.length() == 0) return data;
        
        StringBuilder builder = new StringBuilder();
        int j = data.length() - 1;
        for(int i = 0; i < data.length(); i++){
            if(Character.isLetter(data.charAt(i))){

                while(!Character.isLetter(data.charAt(j)) && j >= 0){
                    j--;
                }
                
                builder.append(data.charAt(j));
                j--;
            }else{

                builder.append(data.charAt(i));
            }
        }

        return builder.toString();
    }


    public static void main(String[] args) {

        System.out.println("Reverse only letters of a string solution using two pointer approach.");
        ReverseOnlyLettersUsingTwoPointer reverseOnlyLetters = new ReverseOnlyLettersUsingTwoPointer();
        String data = "d-ta-bpa-cpa-or";
        String reversed = reverseOnlyLetters.reverse(data);
        System.out.println(reversed);
    }
}