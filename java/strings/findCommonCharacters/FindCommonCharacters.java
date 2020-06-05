package strings.findCommonCharacters;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    
    public List<String> findCommonCharacters(String[] data){
        
        
        if(data == null || data.length == 0) return new ArrayList<>();
        int[] maxCount = new int[26];
        initializeMaxCount(maxCount);
        buildMaxCount(maxCount, data);

        List<String> result = fillResultList(maxCount);

        return result;
    }

    private void initializeMaxCount(int[] maxCount){
        for (int i = 0; i < maxCount.length; i++) {
            maxCount[i] = Integer.MAX_VALUE;
        }
    }


    private void buildMaxCount(int[] maxCount, String[] data){

        for (String item : data) {
            
            int[] currentCount = new int[26];

            for(int i = 0; i < item.length(); i++){
                int charIndex = (item.charAt(i) - 'a');
                currentCount[charIndex] += 1;
            }

            for (int i = 0; i < maxCount.length; i++) {
                maxCount[i] = Math.min(maxCount[i], currentCount[i]);
            }

        }
    }


    private List<String> fillResultList(int[] maxCount){
        
        List<String> result = new ArrayList<>();
        for(int i = 0; i < maxCount.length; i++){
            int count = maxCount[i];
            int j = 0;
            while(j < count){

                char ch = (char) (i + 'a');
                result.add(ch + "");
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        FindCommonCharacters commonCharacters = new FindCommonCharacters();
        String[] input = new String[]{"bella", "label", "roller"};
        List<String> commonChars = commonCharacters.findCommonCharacters(input);
        for (String ch : commonChars) {
            System.out.print(ch + " ");
        }
    }
}