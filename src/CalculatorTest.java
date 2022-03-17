import org.junit.Test;
import org.junit.Before;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {

    StackInterface arrayStack = new ResizableArrayStack();

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
    }

    /**
     *  This tests the evaluation the postfix expression
     */
    @Test
    public void testEvaluatePostFix(){

    }


}
