package twodimensionalarray.transpose;

public class TransposeMatrix {

    public int[][] transpose(int[][] data){
        
        if(data == null || data.length == 0) return data;
        
        int[][] result = new int[data[0].length][data.length];
        
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[j][i] = data[i][j];
            }
        }
        return result;
    }

    public void display(int[][] data){
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println(); 
         }
    }

    public static void main(String[] args) {
 
        TransposeMatrix matrix = new TransposeMatrix();

        int[][] data = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Data is :");
        matrix.display(data);
        int[][] transposed = matrix.transpose(data);
        System.out.println("Transposed matrix is :");
        matrix.display(transposed);
    }
    
}