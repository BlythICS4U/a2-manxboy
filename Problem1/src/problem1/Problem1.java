package problem1;

import java.util.Scanner;

/**
 *
 * @author cgallinaro
 */
public class Problem1 {
    
    public static interface Function {        
        public double eval(double x, double y);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //promt user for doubles
        System.out.println("please input a value for x: ");
        double x = scanner.nextDouble();
        
        System.out.println("please input a value for y: ");
        double y = scanner.nextDouble();
        
        System.out.println("f(" + x + ", " + y + ") = " + f.eval(x, y));
        System.out.println("g(" + x + ", " + y + ") = " + g.eval(x, y));
        System.out.println("h(" + x + ", " + y + ") = " + h.eval(x, y));
        System.out.println("i(" + x + ", " + y + ") = " + i.eval(x, y));
        System.out.println("j(" + x + ", " + y + ") = " + j.eval(x, y));
    }
    
    //f(x) = sqrt(x)
    public static Function f = (x, y) -> Math.sqrt(x + 1);
    
    //g(x) = x^3 - 2x^2 + x - 4
    public static Function g = (x, y) -> Math.pow(x, 3) - 2 * Math.pow(x, 2) + x - 4;
    
    //h(x) = sin^2(x), where x is angle radians
    public static Function h = (x, y) -> Math.pow(Math.sin(x), 2);
    
    //i(x) = sin^2(x), where x is angle degrees
    public static Function i = (x, y) -> Math.pow(Math.sin(Math.toRadians(x)), 2);
    
    //j(x, y) = x^2 + y^2
    public static Function j = (x, y) -> x * x + y * y;
}
