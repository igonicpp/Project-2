import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Calculator {

    public static void main(String[] args){
        testCalculator();


    }


    /**
     * JUnit test calling upon methods in CalculatorTest.class. Prints out failures. If Successful, prints out successful = true message.
     */
    public static void testCalculator(){
        Result result = JUnitCore.runClasses(CalculatorTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Resizable Array Bag test cases were successful? = " + result.wasSuccessful());
    }
}
