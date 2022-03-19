import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Calculator {

    public static void main(String[] args){
        testCalculator();

        System.out.println("Converting a*b/(c-a)+d*e into a postfix expression using LinkedStack.toPostFix()");
        System.out.println("LinkedStack.toPostFix(): " + LinkedStack.toPostFix("a*b/(c-a)+d*e"));
        System.out.println("Evaluating " + LinkedStack.toPostFix("a*b/(c-a)+d*e") + " for a = 2, b = 3, c = 4, d = 5, e = 6 using ResizableArrayStack.evaluatePostFix()");
        System.out.println("ResizableArrayStack.evaluatePostFix(): " + ResizableArrayStack.evaluatePostFix("2*3/(4-2)+5*6"));

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
