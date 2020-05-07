package heap.runningmedian;

import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    
    public double[] getMedians(int[] elements){

        //Max Heap...
        PriorityQueue<Integer> lowers = new PriorityQueue<>((a, b) -> -1 * a.compareTo(b));

        //Min Heap...
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        if(isEmpty(elements)){

            throw new IllegalArgumentException("Empty Array.");
        }

        int first = elements[0];
        double[] medians = new double[elements.length];
        //Just to keep track of the element we are iterating on.
        int i = 0;

        for (int element : elements) {
            
            //Add the elements smaller or equal than the first to lowers and bigger elements to highers.
            if(element <= first){

                lowers.add(element);
            }else{
                highers.add(element);
            }

            //Figure out the smaller and bigger heap and transfer balance out the elements.
            PriorityQueue<Integer> smaller = lowers.size() > highers.size() ? highers : lowers;
            PriorityQueue<Integer> bigger = lowers.size() > highers.size() ? lowers : highers;
            if(bigger.size() - smaller.size() > 1){

                shiftElements(bigger, smaller);
            }

            //If we have even number of elements, 
            //then the median will the be average of max from lowers and min from highers.
            if(bigger.size() - smaller.size() == 0){
                
                medians[i] = (bigger.peek() + smaller.peek())/2.0;
            }else{

            //If the number of elements are not even, then we will have atmost 1 element extra in bigger heap.
            //And the median will be the extra element in the 
            medians[i] = bigger.peek();
            
            }

            i++;
        }
        return medians;
    }

    private void shiftElements(PriorityQueue<Integer> bigger, PriorityQueue<Integer> smaller){

        while(bigger.size() - smaller.size() > 1){

            smaller.add(bigger.poll());
        }
    }

    private boolean isEmpty(int[] elements){

        if(elements == null || elements.length == 0){

            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public static void main(String[] args) {
 
        System.out.println("Running median for the given array.");
        int[] elements = new int[6];
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        
        while(i < elements.length){
            
            System.out.println("Enter the number to add it to array:");
            int num = scanner.nextInt();
            elements[i] = num;
            i++;
        }
        
        System.out.println("Finding running median of the array!");
        System.out.println("Running median of the given elements array is:");
        RunningMedian runningMedian = new RunningMedian();
        double[] medians = runningMedian.getMedians(elements);
        for (double median : medians) {
            System.out.print("  " + median);
        }
    }
}