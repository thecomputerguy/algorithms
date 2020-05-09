package memoization.coinchange;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {

    public static long makeChange(int money, int[] coins){

        return makeChange(money, coins, 0, new HashMap<String, Long>());
    }

    private static long makeChange(int money, int[] coins, int index, Map<String, Long> memoTable){

        //No money, one way to make change, use no coin at all.
        if(money == 0){

            return 1;
        }

        //No coin, there is no way to make change. Because we don' have a coin.
        if(index >= coins.length){

            return 0;
        }

        String key = money + "-" + coins[index];
        if(memoTable.containsKey(key)){
            
            return memoTable.get(key);
        }

        int amountWithCoin = 0;
        long noOfWays = 0;
        while(amountWithCoin <= money){

            int remainingMoney = money - amountWithCoin;
            noOfWays += makeChange(remainingMoney, coins, index+1, memoTable);
            amountWithCoin += coins[index];
        }

        memoTable.put(key, noOfWays);
        return noOfWays;
    }
    
    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)){

            System.out.println("Enter amount: ");
            int money = scan.nextInt();
            System.out.println("Enter the number of coins: ");
            int num = scan.nextInt();
            int i = 0;
            int[] denomination = new int[num];
            while(i < num){

                System.out.println("Enter coin:");
                int coin = scan.nextInt();
                denomination[i] = coin;
                i++;
            }

            System.out.println("Number of ways to make change for " + money + " with given coins are ");
            System.out.println(makeChange(money, denomination)); 
        } 
    }
}