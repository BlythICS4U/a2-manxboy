package problem2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cgallinaro
 */
public class Problem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input size: ");
        int size = scanner.nextInt();
        
        boolean[] primes = new boolean[size];
        
        Arrays.fill(primes, true);
        
        for (int i = 2; i < Math.sqrt(size); i++) {
            if (primes[i]) {
                for (int j = i*i; j < size; j +=i) {
                    primes[j] = false;
                }
            }
        }
        
        System.out.println("All primes less than or equal to 500 are:");
        
        for (int i = 2, j = 0; i < primes.length; i++) {
            if (primes[i]) {
                if (j >= 9) {
                    System.out.print(i + "\n");
                    j = 0;
                } else {
                    System.out.print(i + "\t");
                    j++;
                }
            }
        }
    }
    
}
