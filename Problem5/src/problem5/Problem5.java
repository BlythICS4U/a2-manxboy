package problem5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cgallinaro
 */
public class Problem5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("Teacher data.txt");
        
        String contents;
        
        
        /**
         * READ FILE
         */
        
        try {
            //read all files into a string
            contents = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException ex) {
            Logger.getLogger(Problem5.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        
        /**
         * LOAD DATA
         */
        
        String[][] data = new String[50][3];
        
        String[] split = contents.split("(\\s)+");
                
        //ittorator for split string
        int i = 0;
                
        //loop trough the data array, loading values form the split string
        for (int j = 0; j < 50; j++) {
            for (int k = 0; k < 3; k++) {
                data[j][k] = split[i];
                i++;
            }
        }
        
        /**
         * PROCESS DATA
         */
        
        int averageYearsMathCounter    = 0;
        int averageYearsScienceCounter = 0;
        int averageYearsTechCounter    = 0;
        
        int mathTeachersTotal    = 0;
        int scienceTeachersTotal = 0;
        int techTeachersTotal    = 0;
        
        
        for (int teacher = 0; teacher < 50; teacher++) {
            switch (data[teacher][TEACHER_SUBJECT]) {
                case "math"    : {
                    averageYearsMathCounter += Integer.parseInt(data[teacher][TEACHER_YEARS]);
                    mathTeachersTotal++;
                    break;
                }
                case "science" : {
                    averageYearsScienceCounter += Integer.parseInt(data[teacher][TEACHER_YEARS]);
                    scienceTeachersTotal++;
                    break;
                }
                case "tech"    : {
                    averageYearsTechCounter += Integer.parseInt(data[teacher][TEACHER_YEARS]);
                    techTeachersTotal++;
                    break;
                }
            }
        }
        
        System.out.printf("Average Number of Years In the Math Department: %.2f\n", (double)averageYearsMathCounter / mathTeachersTotal);
        System.out.printf("Average Number of Years In the Science Department: %.2f\n", (double)averageYearsScienceCounter / scienceTeachersTotal);
        System.out.printf("Average Number of Years In the Tech Department: %.2f\n", (double)averageYearsTechCounter / techTeachersTotal);
        
    }
    
    public static final int TEACHER_NAME = 0;
    public static final int TEACHER_SUBJECT = 1;
    public static final int TEACHER_YEARS = 2;
    
}
