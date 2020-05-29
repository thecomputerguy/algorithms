package maths.robotreturntoorigin;

public class RobotOriginProblem {
 
    public boolean solve(String input){

        //robot never moved, it remained on origin, so return true.
        if (input == null || input.isEmpty()) return true;

        int x = 0;
        int y = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch == 'L'){
                x--;
            }else if(ch == 'R'){
                x++;
            }else if(ch == 'U'){
                y++;
            }else if(ch == 'D'){
                y--;
            }   
        }

        return ((x==0) && (y==0));
    }

    public static void main(String[] args) {
        System.out.println("Robot return to origin problem.");
        RobotOriginProblem robotOriginProblem = new RobotOriginProblem();
        boolean result1 = robotOriginProblem.solve("LRRL");
        System.out.println("has robot come to origin? " + result1);
        boolean result2 = robotOriginProblem.solve("LRRU");
        System.out.println("has robot come to origin? " + result2);
    }  
}