package slidingwindow.allanagramsofthepatterninthegivenstring;

import java.util.*;

public class AllAnagramsOfThePatternInTheGivenString {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<Character, Integer> map = new HashMap<>();
        // Build a count of each character in the pattern
        for (int index = 0; index < pattern.length(); index++) {
            map.put(pattern.charAt(index), map.getOrDefault(pattern.charAt(index), 0) + 1);
        }

        int windowStart = 0, matched = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char charAtWindowEnd = str.charAt(windowEnd);
            if (map.containsKey(charAtWindowEnd)) {
                map.put(charAtWindowEnd, map.get(charAtWindowEnd) - 1);
                if (map.get(charAtWindowEnd) == 0)
                    matched++;
            }

            if (matched == map.size()) {
                resultIndices.add(windowStart);
            }

            if (windowEnd >= pattern.length() - 1) {
                char charAtWindowStart = str.charAt(windowStart);
                if (map.containsKey(charAtWindowStart)) {
                    if (map.get(charAtWindowStart) == 0)
                        matched--;
                    map.put(charAtWindowStart, map.get(charAtWindowStart) + 1);
                }
                windowStart++;
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        String str = "abbcabc";
        String pattern = "abc";
        List<Integer> result = findStringAnagrams(str, pattern);
        System.out.println(Arrays.toString(result.toArray()));
    }
}