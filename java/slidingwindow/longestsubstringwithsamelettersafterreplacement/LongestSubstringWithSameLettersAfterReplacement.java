package slidingwindow.longestsubstringwithsamelettersafterreplacement;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersAfterReplacement {

    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0)
            return 0;
        int maxLength = 0, windowStart = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char charAtWindowEnd = str.charAt(windowEnd);
            map.put(charAtWindowEnd, map.getOrDefault(charAtWindowEnd, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(charAtWindowEnd));

            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                map.put(str.charAt(windowStart), map.get(str.charAt(windowStart)) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String S = "abccde";
        int k = 1;
        int result = findLength(S, k);
        System.out.println(result);
    }
}