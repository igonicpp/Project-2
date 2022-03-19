import org.junit.Test;
import org.junit.Before;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {

    StackInterface arrayStack = new ResizableArrayStack();
    StackInterface linkedStack = new LinkedStack();

    /**
     * Initializes an ArrayStack to use.
     */
    @Before
    public void setUp(){
        testClear();
    }
    /**
     * Several cases to test:
     * Pushing on an empty stack
     * Pushing an object
     * Pushing a Null object
     */
    @Test
    public void testPush(){
        try {
            arrayStack.push("a");
        } catch (Exception e){
            fail("Failure: push() threw an exception: " + e);
        }
        try {
            arrayStack.push("b");
        } catch (Exception e){
            fail("Failure: push() threw an exception: " + e);
        }
        try {
            arrayStack.push(null);
        } catch (Exception e){
            fail("Failure: push() threw an exception: " + e);
        }
        try {
            linkedStack.push("a");
        } catch (Exception e){
            fail("Failure: push() threw an exception: " + e);
        }
        try {
            linkedStack.push("b");
        } catch (Exception e){
            fail("Failure: push() threw an exception: " + e);
        }
        try {
            linkedStack.push(null);
        } catch (Exception e){
            fail("Failure: push() threw an exception: " + e);
        }
    }

    /**
     * Several cases to test:
     * Retrieving from an empty stack (throws exception)
     * Retrieving the top of the stack successfully
     * Retrieving the 2nd of the stack
     */
    @Test
    public void testPop(){
        try {
            arrayStack.pop();
            fail("Failure: Successfully pop into an empty bag.");
        } catch (EmptyStackException e){
            assertEquals(EmptyStackException.class, e.getClass());
        }
        arrayStack.push("1stEntry");
        arrayStack.push("2ndEntry");
        assertEquals("2ndEntry", arrayStack.pop());
        assertEquals("1stEntry", arrayStack.pop());

        try {
            linkedStack.pop();
            fail("Failure: Successfully pop into an empty bag.");
        } catch (EmptyStackException e){
            assertEquals(EmptyStackException.class, e.getClass());
        }
        linkedStack.push("1stEntry");
        linkedStack.push("2ndEntry");
        assertEquals("2ndEntry", linkedStack.pop());
        assertEquals("1stEntry", linkedStack.pop());
    }

    /**
     * Several cases to test:
     * Peeking from an empty stack (throws exception)
     * Peeking the top of the stack successfully
     */
    @Test
    public void testPeek(){
        try {
            arrayStack.peek();
            fail("Failure: Successfully peeked into an empty bag.");
        } catch (EmptyStackException e){
            assertEquals(EmptyStackException.class, e.getClass());
        }
        arrayStack.push("a");
        assertEquals("a", arrayStack.peek());

        try {
            linkedStack.peek();
            fail("Failure: Successfully peeked into an empty bag.");
        } catch (EmptyStackException e){
            assertEquals(EmptyStackException.class, e.getClass());
        }
        linkedStack.push("a");
        assertEquals("a", linkedStack.peek());
    }

    /**
     * Several cases to test:
     * Stack is empty
     * Stack is not empty
     */
    @Test
    public void testIsEmpty(){
        assertEquals(true, arrayStack.isEmpty());
        arrayStack.push("a");
        assertEquals(false, arrayStack.isEmpty());

        assertEquals(true, linkedStack.isEmpty());
        linkedStack.push("a");
        assertEquals(false, linkedStack.isEmpty());
    }

    /**
     * Several cases to test:
     * Stack is empty
     * Stack is not empty
     */
    @Test
    public void testClear(){
        arrayStack.clear();
        assertEquals(true, arrayStack.isEmpty());
        arrayStack.push("a");
        arrayStack.clear();
        assertEquals(true, arrayStack.isEmpty());

        linkedStack.clear();
        assertEquals(true, linkedStack.isEmpty());
        linkedStack.push("a");
        linkedStack.clear();
        assertEquals(true, linkedStack.isEmpty());
    }

    /**
     *  This tests the conversion to postfix expression
     */
    @Test
    public void testConvertToPostFix(){
        assertEquals("ab+", LinkedStack.toPostFix("a+b"));
        assertEquals("ab+c*", LinkedStack.toPostFix("(a+b)*c"));
        assertEquals("abc*+", LinkedStack.toPostFix("a+b*c"));
        assertEquals("ab-c+", LinkedStack.toPostFix("a-b+c"));
        assertEquals("abc^^", LinkedStack.toPostFix("a^b^c"));
        assertEquals("ab/cde-+*", LinkedStack.toPostFix("a/b*(c+(d-e))"));
        assertEquals("ab*ca-d/e*+",LinkedStack.toPostFix("a*b/(c-a)+d*e"));
    }

    /**
     *  This tests the evaluation the postfix expression
     */
    @Test
    public void testEvaluatePostFix(){
        assertEquals(0.5,ResizableArrayStack.evaluatePostFix("24/"),1E-9);
        assertEquals(2,ResizableArrayStack.evaluatePostFix("24+3/"),1E-9);
        assertEquals(33.0,ResizableArrayStack.evaluatePostFix("2*3/(4-2)+5*6"),1E-9);
    }


}
