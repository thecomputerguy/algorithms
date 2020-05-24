package maths.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    
    private List<List<Integer>> buildTriangle(int rows) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for(int i = 1; i < rows; i++){

            //Get the previous row.
            List<Integer> prevRow = result.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for(int j = 1; j < i; j++){
                //Build the new row.
                //New row is the previous row's two elements sum. 
                currentRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            currentRow.add(1);
            result.add(currentRow);
        }

        return result;
    }

    public static void main(String[] args) {
        
        System.out.println("Printing the pascal triangle.");
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> triangle = pascalTriangle.buildTriangle(8);

        for (List<Integer> row : triangle) {
            
            for (Integer element : row) {
                
                System.out.print(element + " ");
            }

            //Add a new line
            System.out.println();
        }
    }

}