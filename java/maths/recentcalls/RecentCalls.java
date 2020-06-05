
package maths.recentcalls;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCalls {

    Queue<Integer> queue;

    public RecentCalls(){
        queue = new LinkedList<>();
    }

    public int ping(int t){
        queue.offer(t);

        while(queue.peek() < t-3000){
            queue.remove();
        }

        return queue.size();
    }

    public static void main(String[] args) {
        
        RecentCalls recentCalls = new RecentCalls();
        System.out.println(recentCalls.ping(3000));
        System.out.println(recentCalls.ping(3500));
        System.out.println(recentCalls.ping(4000));
        System.out.println(recentCalls.ping(4500)); 
    }
}