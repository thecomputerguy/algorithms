package balancedparenthesis;
import java.util.Stack;

public class BalancedParenthesis {
    final String[][] brackets = {{"{", "}"}, {"[", "]"}, {"<", ">"}};

    public boolean isOpen(String bracket){

        for (String[] bracketPair : brackets) {
            if(bracketPair[0].equals(bracket)){
                return true;
            }
        }

        return false;
    }

    public boolean isValid(String expression){

        if(expression == null || expression.isEmpty()){
            return false;
        }
        Stack<String> stack = new Stack<String>();
        String[] expressionArray =  expression.split("");
        for (String c : expressionArray){
            //if it is open parenthesis then put it in the stack.
            //if it is not open parenthesis 
            //then pop out the character from the top of the stack and check if it matches the closing bracket
            if(isOpen(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()){

                    return false;
                }
                String poppedChar = stack.pop();

                if(!isValidPair(poppedChar, c)){
                    
                    return false;
                }
            }


        }
        return true;
    }

    private boolean isValidPair(String open, String close) {
        
        for (String[] pair : brackets) {
            if(pair[0].equals(open) && pair[1].equals(close)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    
        String[] expressions = {"{}[]<>", "{]}[<>]", "[]{}<>"};
        BalancedParenthesis balancedParenthesis = new BalancedParenthesis();

        for (String expression : expressions) {
        
            boolean result = balancedParenthesis.isValid(expression);
            System.out.println(String.format("Expression: %s ------> %s", expression, result));
        }
    }
}