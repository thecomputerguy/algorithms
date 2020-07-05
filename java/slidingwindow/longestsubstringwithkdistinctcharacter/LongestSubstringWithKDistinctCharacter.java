package slidingwindow.longestsubstringwithkdistinctcharacter;

import java.util.*;

public class LongestSubstringWithKDistinctCharacter {

    public static int findLength(String str, int k) {
        int winStart = 0;
        int maxLength = Integer.MIN_VALUE;
        int uniqueChars = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {

            char charAtWinEnd = str.charAt(winEnd);

            if (map.containsKey(charAtWinEnd)) {
                map.put(charAtWinEnd, map.get(charAtWinEnd) + 1);
            } else {
                uniqueChars++;
                map.put(charAtWinEnd, 1);
            }

            while (uniqueChars > k) {
                uniqueChars--;
                char charAtWinStart = str.charAt(winStart);
                if (map.get(charAtWinStart) > 1) {
                    map.put(charAtWinStart, map.get(charAtWinStart) - 1);
                } else if (map.get(charAtWinStart) == 1) {
                    map.remove(charAtWinStart);
                }
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