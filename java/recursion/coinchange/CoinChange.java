package recursion.coinchange;

import java.util.Scanner;

public class CoinChange {

    public static long makeChange(int money, int[] coins){

        return makeChange(money, coins, 0);
    }

    private static long makeChange(int money, int[] coins, int index){

        if(money == 0){

            return 1;
        }

        if(index >= coins.length){

            return 0;
        }

        int amountWithCoin = 0;
        long noOfWays = 0;
        while(amountWithCoin <= money){

            int remainingMoney = money - amountWithCoin;
            noOfWays += makeChange(remainingMoney, coins, index+1);
            amountWithCoin += coins[index];
        }

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