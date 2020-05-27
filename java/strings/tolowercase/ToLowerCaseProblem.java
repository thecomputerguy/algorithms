package strings.tolowercase;

import java.util.Scanner;

public class ToLowerCaseProblem {
    
    public String toLowerCase(String data){
        
        if(data == null || data.isEmpty()) return data;
        
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < data.length(); i++){
            char character = data.charAt(i);
            if(Character.isUpperCase(character)){
                char lowerCase = (char) (character + 32);
                builder.append(lowerCase);
            }else{
                builder.append(character);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        
        System.out.println("To lower case problem solution.");
        try(Scanner scan = new Scanner(System.in)){

            System.out.println("Enter the string to convert it to lowercase:");
            ToLowerCaseProblem converter = new ToLowerCaseProblem();
            String newLine = scan.nextLine();
            String lowercase = converter.toLowerCase(newLine);
            System.out.println("String in lower case " + lowercase);
        }
    }
}