package problem6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cgallinaro
 */
public class Problem6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("myMatrices.bin");

        FileInputStream fileStream;
        try {
            fileStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Problem6.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        ObjectInputStream objectStream;
        try {
            objectStream = new ObjectInputStream(fileStream);
        } catch (IOException ex) {
            Logger.getLogger(Problem6.class.getName()).log(Level.SEVERE, null, ex);
            try {
                fileStream.close();
            } catch (IOException ex1) {
                Logger.getLogger(Problem6.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return;
        }

        int[][] matrix1;
        int[][] matrix2;
        
        try {
            matrix1 = (int[][]) objectStream.readObject();
            matrix2 = (int[][]) objectStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Problem6.class.getName()).log(Level.SEVERE, null, ex);
            
            try {
                objectStream.close();
                fileStream.close();
            } catch (IOException ex1) {
                Logger.getLogger(Problem6.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Problem6.class.getName()).log(Level.SEVERE, null, ex);
            try {
                objectStream.close();
                fileStream.close();
            } catch (IOException ex1) {
                Logger.getLogger(Problem6.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return;
        }
        
        int[][] result = multiplyMatrices(matrix1, matrix2);
        
        for (int i = 0; i < result.length; i++) {
            
            System.out.print(getDisplayCharLeft(i));
            
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf("%3d", result[i][j]);
                
                if (j != result[i].length - 1) System.out.print(", ");
            }
            
            System.out.println(getDisplayCharRight(i));
        }
        
        try {
            fileStream.close();
            objectStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Problem6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        
        //resulting matrix (of A x B) is [A.r] x [B.c] size matrix
        int[][] result = new int[rowCount(A)][columnCount(B)];
        
        for (int i = 0; i < rowCount(A); i++) {
            for (int j = 0; j < columnCount(B); j++) {
                result[i][j] = vectorDot(getRow(A, i), getColumn(B, j));
            }
        }
        
        return result;
    }
    
    public static int vectorDot(int[] v1, int[] v2) {
        int result = 0;
        
        for (int i = 0; i < v1.length; i++) {
            result += v1[i] * v2[i];
        }
        
        return result;
    }
    
    public static int rowCount(int[][] matrix) {
        return matrix.length;
    }
    
    public static int[] getRow(int[][] matrix, int row) {
        return matrix[row];
    }
    
    public static int[] getColumn(int[][] matrix, int column) {
        int result[] = new int[rowCount(matrix)];
                
        for (int row = 0; row < rowCount(matrix); row++) {
            result[row] = matrix[row][column];
        }
        
        return result;
    }
    
    public static int columnCount(int[][] matrix) {
        return matrix[0].length;
    }

    
    public static char getDisplayCharLeft(int i) {
        switch (i) {
            case 0 : return '⎡';
            case 1 : return '⎜';
            case 2 : return '⎣';
            default : return ' ';
        }
    }
    
    public static char getDisplayCharRight(int i) {
        switch (i) {
            case 0 : return '⎤';
            case 1 : return '⎟';
            case 2 : return '⎦';
            default : return ' ';
        }
    }
}
