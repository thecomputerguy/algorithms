package twodimensionalarray.spiralmatrix;

import java.util.Scanner;

public class SpiralMatrixCreation {
    
    public int[][] create(int n){
        
        if(n == 0 || n == 1) return new int[][]{};
        int rows = n;
        int columns = n;
        int[][] spiralMatrix = new int[rows][columns];
        int counter = 0;
        int rowStart = 0;
        int rowEnd = rows-1;
        int columnStart = 0;
        int columnEnd = columns-1;

        while(rowStart <=  rowEnd && columnStart <= columnEnd){

            for (int i = columnStart; i <= columnEnd; i++) {
                spiralMatrix[rowStart][i] = ++counter;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                spiralMatrix[i][columnEnd] = ++counter;
            }
            columnEnd--;

            for (int i = columnEnd; i >= columnStart; i--) {
                spiralMatrix[rowEnd][i] = ++counter;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--) {
                spiralMatrix[i][columnStart] = ++counter;
            }
            columnStart++;
        }

        return spiralMatrix;
    }

    public static void main(String[] args) {
        
        System.out.println("creating a spiral matrix solution.");

        try(Scanner scan = new Scanner(System.in)){
            SpiralMatrixCreation matrix = new SpiralMatrixCreation();
            
            System.out.println("Enter the number of rows of spiral matrix");
            int n = scan.nextInt();
            int[][] spriralMatrix = matrix.create(n);
            System.out.println("Spiral matrix created");
            for(int i = 0; i < spriralMatrix.length; i++){
            for(int j = 0; j < spriralMatrix[i].length; j++){
                System.out.print(spriralMatrix[i][j] + "  ");
            }
            System.out.println();   
        }
 
        }
    }
}