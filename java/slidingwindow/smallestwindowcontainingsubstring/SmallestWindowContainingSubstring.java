package slidingwindow.smallestwindowcontainingsubstring;

import java.util.*;

public class SmallestWindowContainingSubstring {

    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> countsMap = new HashMap<>();
        for (int index = 0; index < pattern.length(); index++) {
            countsMap.put(pattern.charAt(index), countsMap.getOrDefault(pattern.charAt(index), 0) + 1);
        }

        int minLength = Integer.MAX_VALUE, windowStart = 0, matched = 0, subStringStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char charAtWindowEnd = str.charAt(windowEnd);
            if (countsMap.containsKey(charAtWindowEnd)) {
                countsMap.put(charAtWindowEnd, countsMap.get(charAtWindowEnd) - 1);
                if (countsMap.get(charAtWindowEnd) >= 0)
                    matched++;
            }

            while (matched == pattern.length()) {

                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStringStart = windowStart;
                }
                char charAtWindowStart = str.charAt(windowStart);
                if (countsMap.containsKey(charAtWindowStart)) {

                    if (countsMap.get(charAtWindowStart) == 0) {
                        matched--;
                    }
                    countsMap.put(charAtWindowStart, countsMap.get(charAtWindowStart) + 1);
                }
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : str.substring(subStringStart, subStringStart + minLength);
    }

    public static void main(String[] args) {
        String str = "abdabca";
        String pattern = "abc";
        String result = findSubstring(str, pattern);
        System.out.println("result : " + result);

        String str1 = "adcad";
        String pattern1 = "abc";
        String result1 = findSubstring(str1, pattern1);
        System.out.println("result : " + result1);
    }
}