import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    /**
     * JUnit test calling upon methods in ArrayBagTest.class. Prints out failures. If Successful, prints out successful = true message.
     */
    public static void testResizableArrayBag(){
        Result result = JUnitCore.runClasses(ArrayStackTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Resizable Array Bag test cases were successful? = " + result.wasSuccessful());
    }

    /**
     * JUnit test calling upon methods in LinkedBagTest.class. Prints out failures. If Successful, prints out successful = true message.
     */

    public static void testLinkedBag(){
        Result result = JUnitCore.runClasses(LinkedStackTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Linked bag test cases were successful? = " + result.wasSuccessful());
    }
}
