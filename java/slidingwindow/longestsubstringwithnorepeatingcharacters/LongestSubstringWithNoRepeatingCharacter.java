package slidingwindow.longestsubstringwithnorepeatingcharacters;

import java.util.*;

public class LongestSubstringWithNoRepeatingCharacter {

    public static int findLength(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int winStart = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> holder = new HashMap<>();
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {

            if (holder.containsKey(str.charAt(winEnd))) {
                winStart = Math.max(winStart, holder.get(str.charAt(winEnd)) + 1);
            }
            holder.put(str.charAt(winEnd), winEnd);
            maxLength = Math.max(maxLength, winEnd - winStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String S = "abccde";
        int result = findLength(S);
        System.out.println(result);
    }
}