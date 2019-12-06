/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;


/**
 *
 * @author cgallinaro
 */
public class Problem4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("myText.txt");
        File data = new File("myTextData.txt");
        
        String contents;
        try {
            contents = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException ex) {
            //file not found: log exception and return
            Logger.getLogger(Problem4.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        int numberOfWords            = 0;
        int numberOfLines            = 0;
        int averageWordLengthCounter = 0;
        String longestWord           = "";
        
        /**
         * REGEX:
         *  - first, replace all periods with nothing: "([.])" matches periods
         *  - second, split the string between all words, by splitting at any
         *    whitespace that has more characters in front of it.
         */
        String[] words = contents.replaceAll("([.])", "").split("([\\s])+(?=[\\s\\S])");
        
        //get the number of words by counting the array
        numberOfWords = words.length;
        
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
            
            averageWordLengthCounter += word.length();
        }
        
        //number of lines
        numberOfLines = countOccurrencesOf(contents, '\n');
        
        
        try {
            FileWriter fileWriter = new FileWriter(data);
            
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            printWriter.println("The file \"" + file.getName() + "\" was successfully read.\n");
            
            printWriter.printf("%-21s %d\n"  , "Number of Words:", numberOfWords);
            printWriter.printf("%-21s %d\n"  , "Number of Lines:", numberOfLines);
            printWriter.printf("%-21s %s\n"  , "Longest Word:", longestWord);
            printWriter.printf("%-21s %d\n"  , "Longest Word Length:", longestWord.length());
            printWriter.printf("%-21s %.1f\n", "Average Word Length:", (double)averageWordLengthCounter / numberOfWords);
            
            printWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Problem4.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
                
        
                
    }
    
    public static int countOccurrencesOf(String source, char search) {
        int occurences = 0;
        
        for (char character : source.toCharArray()) {
            if (character == search) occurences++;
        }
        
        return occurences;
    }
    
}
