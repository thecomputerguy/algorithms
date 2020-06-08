package twodimensionalarray.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    
    public List<Integer> spriralMatrix(int[][] data){
        List<Integer> result = new ArrayList<>();
        
        if(data == null || data.length == 0) return result; 

        int rowBegin = 0;
        int rowEnd = data.length-1;
        int columnBegin = 0;
        int columnEnd = data[0].length-1;

        while(rowBegin <= rowEnd && columnBegin <= columnEnd){

            for(int i = columnBegin; i <= columnEnd; i++){
                result.add(data[rowBegin][i]);
            }
            rowBegin++;

            for(int i = rowBegin; i <= rowEnd; i++){
                result.add(data[i][columnEnd]);
            }
            columnEnd--;

            for(int i = columnEnd; i >= columnBegin; i--){
                result.add(data[rowEnd][i]);
            }
            rowEnd--;

            for(int i = rowEnd; i >= rowBegin; i--){
                result.add(data[i][columnBegin]);
            }
            columnBegin++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Spiral matrix solution.");
        SpiralMatrix matrix = new SpiralMatrix();

        int[][] data = new int[][]{{1, 2, 3, 4, 5},{6, 7, 8, 9, 10},{11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        List<Integer> spriral = matrix.spriralMatrix(data);
        spriral.forEach(element -> System.out.print(element + " "));
    }
}

// 1  2  3  4  5
// 6  7  8  9  10
// 11 12 13 14 15
// 16 17 18 19 20