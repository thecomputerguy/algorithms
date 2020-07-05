package slidingwindow.fruitsinthebasket;

import java.util.*;

class FruitsInTheBasket {

    public static int findLength(char[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int maxFruits = Integer.MIN_VALUE;
        int winStart = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            char fruit = arr[winEnd];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            while (map.size() > 2) {
                char charAtWinStart = arr[winStart];
                map.put(charAtWinStart, map.get(charAtWinStart) - 1);
                if (map.get(charAtWinStart) == 0) {
                    map.remove(charAtWinStart);
                }
                winStart++;
            }
            maxFruits = Math.max(maxFruits, winEnd - winStart + 1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        char[] fruits = new char[] { 'A', 'B', 'C', 'B', 'B', 'C' };
        int result = findLength(fruits);
        System.out.println(result);
    }

}