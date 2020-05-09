package dfs.biggestregionproblem;

import java.util.Scanner;

public class BiggestRegion {

    private static int getRegionSize(int[][] matrix, int row, int column) {

        // Check if row and column is with in the bounds.
        if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[row].length) {
            return 0;
        }

        // while moving in the region, if we get a cell that has a value of 0 then
        // region size is 0;
        if (matrix[row][column] == 0) {
            return 0;
        }

        // If we have reached so far then we know the cell represented by row and column
        // is not 0.
        // We have visited this cell now, so mark the cell as visited.
        matrix[row][column] = 0;

        // Set the initial size to 1 as the current cell has been considered.
        int size = 1;

        // Now, move in all directions to get the region size i.e move up, down, left,
        // right and diagonal.
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (r != row && c != column) {
                    size += getRegionSize(matrix, r, c);
                }
            }
        }

        return size;
    }

    public static int biggestRegion(int[][] matrix) {

        int size = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1) {

                    size += getRegionSize(matrix, row, column);
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            System.out.println("Biggest Region of 1's problem");
            System.out.println("Enter the number of rows: ");
            int rows = scan.nextInt();
            System.out.println("Enter the number of cols: ");
            int cols = scan.nextInt();

            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.println("Choose the value for cell: " + " row " + i + " col " + j);
                    matrix[i][j] = scan.nextInt();
                }
            }

            System.out.println("Matrix is: ");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println("");
            }

            System.out.println("Biggest region with 1 is " + biggestRegion(matrix));

        }

    }
}