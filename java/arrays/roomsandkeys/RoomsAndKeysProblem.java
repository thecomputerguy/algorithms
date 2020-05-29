package arrays.roomsandkeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class RoomsAndKeysProblem {
    
    public boolean solve(List<List<Integer>> rooms){

        if(rooms == null || rooms.isEmpty()) return true;
        Stack<Integer> keys = new Stack<>();
        boolean[] visited = new boolean[rooms.size()];
        //first room is always unlocked. first room is room 0 in this case.
        keys.addAll(rooms.get(0));
        //Mark first rooom as visited.
        visited[0] = true;

        while(!keys.isEmpty()){

            int currentKey = keys.pop();
            List<Integer> newKeys = rooms.get(currentKey);
            for (Integer newKey : newKeys) {
                if(!visited[newKey]){
                    visited[newKey] = true;
                    keys.addAll(rooms.get(newKey));
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            System.out.print(visited[i] + " ");
            if (visited[i] == false){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RoomsAndKeysProblem roomsAndKeysProblem = new RoomsAndKeysProblem();
        System.out.println("Rooms and keys problem.");
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        room1.add(3);

        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        room2.add(0);
        room2.add(1);

        List<Integer> room3 = new ArrayList<>();
        room3.add(2);

        List<Integer> room4 = new ArrayList<>();
        room4.add(2);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
       boolean result = roomsAndKeysProblem.solve(rooms);
        System.out.println("did we unlock all the rooms? " + result);
    }
}