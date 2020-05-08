package searching.binarysearch.icecreamparlourproblem;

import java.util.Arrays;
import java.util.Scanner;

public class IcecreamParlourProblem{

    private int indexOf(int[] menu, int amount, int exceptIndex){

        for (int i = 0; i < menu.length; i++) {
            
            if(menu[i] == amount && i != exceptIndex){
                return i;
            }
        }

        return -1;
    }

    private int[] getIndices(int[] menu, int amount1, int amount2){

        int index1 = indexOf(menu, amount1, -1);
        int index2 = indexOf(menu, amount2, index1);

        //this is to keep the item with smaller cost first.
        int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
        return indices;
    }

    public int[] solve(int[] menu, int money){

        //Create a clone and sort the clone of menu, so that we can use binary search to search the complement.
        int[] sortedClone = menu.clone();
        
        //sort the clone to use binary search.
        Arrays.sort(sortedClone);

        for(int i = 0; i < sortedClone.length; i++){

            //For each item in the menu, we try to find the complement of the money used in the sortedClone to find the second item.
            int complement = money - sortedClone[i];
            int index = Arrays.binarySearch(sortedClone, i+1, sortedClone.length, complement);
            if(index >= 0 && index < sortedClone.length && sortedClone[index] == complement){

                int[] indices = getIndices(menu, sortedClone[i], complement);
                return indices;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        
        System.out.println("Icecream parlour problem:");
        try(Scanner scan = new Scanner(System.in)){
            
            System.out.println("Enter the number of items you want in the menu:");
            int num = scan.nextInt();
            int[] menu = new int[num];

            int i = 0;
            while(i < num){

                System.out.println("Enter the menu value:");
                int cost = scan.nextInt();
                menu[i] = cost;
                i++;
            }

            System.out.println("Enter the money that you want to spend:");
            int money = scan.nextInt();
            IcecreamParlourProblem icecreamParlourProblem = new IcecreamParlourProblem();
            int[] indices = icecreamParlourProblem.solve(menu, money);
            if(indices == null){

                System.out.println("No items could be bought!");
                return;
            }

            System.out.println("Bought the items with money " + menu[indices[0]] +" and "+ menu[indices[1]]);
        }
    }
}