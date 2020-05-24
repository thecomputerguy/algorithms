package bfs.noofislandsproblem;

public class NumberOfIslands {
    
    public int numberOfIslands(char[][] grid){

        //check if grid is null or grid is empty, then return 0, which indicates that there are no islands.
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int counter = 0;
        //Iterate through the grid to find 1's and do a breadth first search from there to find all the connected cells which are 1's.

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){

                if(grid[i][j] == '1'){
                    //Found 1 so increment by 1 as we have found one island.
                    counter++;
                    //BFS on this cell to find all the connected cells.
                    bfs(grid, i, j);
                }
            }
        }
        return counter;
    }

    private void bfs(char[][] grid, int row, int col){
        //First check the boundaries and also if the character at this cell is 0 then return immediately.
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0'){

            return;
        }

        //Clear the current cell by setting it to 0, so that we do not visit this cell again.
        grid[row][col] = '0';
        //Explore
        bfs(grid, row-1, col); //up
        bfs(grid, row+1, col); //down
        bfs(grid, row, col-1); //left
        bfs(grid, row, col+1); //right

    }

    public static void main(String[] args) {
        
        System.out.println("Building a 2d grid to represent islands. 0 represents water, 1 represents island.");
        char[][] grid = new char[][]{{'1','1','1'}, {'0', '1' ,'0'}, {'0', '0' ,'1'}};
        NumberOfIslands solution = new NumberOfIslands();
        int numOfIslands = solution.numberOfIslands(grid);
        System.out.println("Number of islands are " + numOfIslands);
    }
}