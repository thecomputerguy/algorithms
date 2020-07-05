package slidingwindow.longestsubstringwithkdistinctcharacter;

import java.util.*;

public class LongestSubstringWithKDistinctCharacter {

    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            return 0;
        int winStart = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {

            char charAtWinEnd = str.charAt(winEnd);

            map.put(charAtWinEnd, map.getOrDefault(charAtWinEnd, 0) + 1);

            while (map.size() > k) {
                char charAtWinStart = str.charAt(winStart);
                map.put(charAtWinStart, map.get(charAtWinStart) - 1);
                if (map.get(charAtWinStart) == 0)
                    map.remove(charAtWinStart);
                winStart++;
            }
            maxLength = Math.max(maxLength, winEnd - winStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int k = 3;
        String str = "cbbebi";
        int result = findLength(str, k);
        System.out.println(result);

        int k1 = 1;
        String str1 = "araaci";
        int result1 = findLength(str1, k1);
        System.out.println(result1);
    }
}