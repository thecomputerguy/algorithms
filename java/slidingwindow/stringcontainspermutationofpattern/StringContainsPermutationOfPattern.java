package slidingwindow.stringcontainspermutationofpattern;

import java.util.HashMap;
import java.util.Map;

public class StringContainsPermutationOfPattern {

    public static boolean findPermutation(String str, String pattern) {
        if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0)
            return false;
        // build a hashmap containing frequency of characters in the hashmap.
        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < pattern.length(); index++) {
            map.put(pattern.charAt(index), map.getOrDefault(pattern.charAt(index), 0) + 1);
        }

        int windowStart = 0, matched = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char charAtWindowEnd = str.charAt(windowEnd);
            if (map.containsKey(charAtWindowEnd)) {
                map.put(charAtWindowEnd, map.get(charAtWindowEnd) - 1);
                if (map.get(charAtWindowEnd) == 0) {
                    matched++;
                }
            }

            if (matched == map.size()) {
                return true;
            }

            if (windowEnd >= pattern.length() - 1) {
                char charAtWindowStart = str.charAt(windowStart);
                if (map.containsKey(charAtWindowStart)) {
                    if (map.get(charAtWindowStart) == 0) {
                        matched--;
                    }

                    map.put(charAtWindowStart, map.get(charAtWindowStart) + 1);
                }
                windowStart++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "aaacb";
        String pattern = "abc";
        boolean result = findPermutation(str, pattern);
        System.out.println(result);
    }
}