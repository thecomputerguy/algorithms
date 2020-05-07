package map.hashmap.ransomnote;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {
    
    private static boolean canBuildRansomeNote(String[] magazine, String[] note){

        Map<String, Integer> lookup = new HashMap<>();

        //Build the magazine.
        for (String word : magazine) {
            
            if(lookup.containsKey(word)){
            
                lookup.put(word, lookup.get(word)+1);
            }else{
                lookup.put(word, 1);
            }
        }

        //Go through each word in the ransome note.
        for(String word : note){
            
            Integer count = lookup.get(word);
            if(count == null || count == 0){
                return false;
            }
            lookup.put(word, lookup.get(word) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        
        System.out.println("Classic Ransom Note problem.");
        String[] magazine = {"hey", "doggy", "wanna", "go", "for", "a", "walk", "i", "wanna", "kidnap", "you", "your", "have"};
        String[] note1 = {"i", "have", "your", "doggy"};
        System.out.println("Can i build ransome note?");
        System.out.println(canBuildRansomeNote(magazine, note1));

        String[] note2 = {"you", "are", "gonna", "pay"};
        System.out.println("Can i build ransome note?");
        System.out.println(canBuildRansomeNote(magazine, note2));
    }
}