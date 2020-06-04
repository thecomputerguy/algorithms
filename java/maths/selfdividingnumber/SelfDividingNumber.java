package maths.selfdividingnumber;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumber {
    
    public List<Integer> selfDividingNumbers(int left, int right){
        
        List<Integer> result = new ArrayList<>();
        
        while(left <= right){
        
            if(isSelfDividing(left)) result.add(left);
            left++;
        }

        return result;
    }

    private boolean isSelfDividing(int num){
        for(char ch : String.valueOf(num).toCharArray()){
            if(ch == '0' || (num % (ch - '0')) > 0){
                return false;       
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        System.out.println("Self dividing number solution.");
        SelfDividingNumber selfDividingNumber = new SelfDividingNumber();
        List<Integer> numbers = selfDividingNumber.selfDividingNumbers(21, 231);
        numbers.forEach(number -> System.out.print(number + " "));
    }
}