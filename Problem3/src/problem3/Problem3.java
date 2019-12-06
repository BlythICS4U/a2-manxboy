package problem3;

/**
 *
 * @author cgallinaro
 */
public class Problem3 {

    public static final int gradesArray[][]={{ 56 , 38 , 38 , 88 , 52 , 42 },
                             { 85 , 35 , 91 , 94 , 60 , 47 },
                             { 78 , 62 , 70 , 42 , 93 , 65 },
                             { 33 , 75 , 82 , 45 , 73 , 83 },
                             { 60 , 80 , 71 , 82 , 73 , 38 },
                             { 80 , 55 , 48 , 59 , 36 , 80 },
                             { 30 , 91 , 79 , 81 , 61 , 61 },
                             { 47 , 54 , 68 , 64 , 73 , 65 },
                             { 32 , 54 , 84 , 52 , 64 , 80 },
                             { 82 , 82 , 39 , 65 , 48 , 41 },
                             { 65 , 81 , 81 , 38 , 93 , 86 },
                             { 44 , 74 , 64 , 61 , 58 , 77 },
                             { 31 , 31 , 44 , 93 , 52 , 94 }};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //print table header
        System.out.println("Name           Test 1  Test 2  Test 3  Test 4  Test 5  Test 6  Average\n-------------  ------  ------  ------  ------  ------  ------  -------");
        
        /**
         * STUDENTS
         */
        
        //ittorate through all the students
        for (int student = 0; student < 13; student++) {
            
            //print out the student table label
            System.out.printf("%-13s", "Student " + (student + 1));
            
            double average = 0;
            
            //ittorate through all the tests of a student
            for (int test = 0; test < 6; test ++) {
                
                //print out the test
                System.out.printf("%8d", gradesArray[student][test]);
                
                //add test the average total
                average += gradesArray[student][test];
            }
            
            //divide the average total by six and then display, fixing to 2 decimal places
            System.out.printf("%9.2f\n", average / 6);
        }
        
        /**
         * TEST AVERAGE
         */
        
        System.out.print("\nTest Average ");
        
        //total of all of the averages from the tests
        double testsAverageTotal = 0;
        
        //ittorate through every test
        for (int test = 0; test < 6; test++) {
            
            //total of the individual test's scores
            double total = 0;
            
            //ittorate through each student
            for (int student = 0; student < 13; student++) {
                
                //add that student's grade for that test to the total
                total += gradesArray[student][test];
            }
            
            //divide the total by the number of students to create the average
            double average = total / 13;
            
            //add the average to the total of test averages
            testsAverageTotal += average;
            
            //print the test's average
            System.out.printf("%8.1f", average);
        }
        
        /**
         * CLASS AVERAGE
         */
        
        //get the average of all the tests
        double classAverage = testsAverageTotal / 6;
        
        //print the average of all the tests
        System.out.printf("\n\nClass Average: %3.1f", classAverage);
    }
}
