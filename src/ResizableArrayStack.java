import java.util.Arrays;
import java.util.EmptyStackException;

public class ResizableArrayStack<T> implements StackInterface<T>{

    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
    private boolean integrityOK = false;

    public ResizableArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * The cast is safe because new Array contains null entries.
     */
    public ResizableArrayStack(int initialCapacity){
        integrityOK = false;
        checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = 1;
        integrityOK = true;
    }

    /**
     * copy constructor
     */


    @Override
    public void push(T newEntry) {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    @Override
    public T pop() {
        checkIntegrity();

        if(isEmpty())
            throw new EmptyStackException();
        else{
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }

    @Override
    public T peek() {
        checkIntegrity();
        if(isEmpty())
            throw new EmptyStackException();
        else return stack[topIndex];

    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void clear() {
        checkIntegrity();

        while(topIndex > -1){
            stack[topIndex] = null;
            topIndex--;
        }

    }

    /** Check the capacity the stack and if the stack is full it will give new length to the stack.*/
    private void ensureCapacity() {
        if (topIndex >= stack.length - 1) {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }
    /**
     * Simple check if the integrity of the stack is OK. Ensures that the stack is properly initialized with proper space.
     */
    private void checkIntegrity(){
        if (!integrityOK){
            throw new SecurityException("ArrayStack object is corrupt.");
        }
    }
    /**
     * Checks to see if given capacity does not exceed set MAX_CAPACITY. Throws an exception if it exceeds.
     * @param capacity Capacity to check if less than MAX_CAPACITY. If greater, throws an exception.
     */
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack whose " + "capacity exceeds allowed " + "maximum of " + MAX_CAPACITY);
    }
    /**
     * 
     * @param postfix equation that must be solved 
     * @return final value of the equation
     */
    public static double evaluatePostFix(String postfix){
        ResizableArrayStack<Double> stack = new ResizableArrayStack<Double>();
        char nextCharacter;
        double operandOne;
        double operandTwo;
        double result = 0.0;
        String copyPostFix = postfix;
        // while the length of the copy of postfix is greater than 0
        while(copyPostFix.length() > 0){
            nextCharacter = copyPostFix.charAt(0);
            // checks if the length of the copy postfix equation is greater than 1
            if(copyPostFix.length() > 1){
                copyPostFix = copyPostFix.substring(1);
            }
            else if(copyPostFix.length() == 1){
                copyPostFix = "";
            }
            // goes through possible cases for nextCharacter
            switch(nextCharacter){
                // if the value is a number, push the double version of that value onto the stack
                case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8':case '9':
                    stack.push(Double.parseDouble(String.valueOf(nextCharacter)));
                    break;
                case'+': case'-': case '*': case '/': case '^':
                // if the value is an operation, pop the two numbers from the stack and perform the required operation then push that value onto the stack
                    operandOne = stack.pop();
                    operandTwo = stack.pop();
                    if(nextCharacter == '+'){
                        result = (operandTwo + operandOne);
                    }
                    if(nextCharacter == '-'){
                        result =  (operandTwo - operandOne);
                    }
                    if(nextCharacter == '*'){
                        result = (operandTwo * operandOne);
                    }
                    if(nextCharacter == '/'){
                        result =  (operandTwo / operandOne);
                    }
                    if(nextCharacter == '^'){
                        result =  (Math.pow(operandTwo, operandOne));
                    }
                    stack.push(result);
                    break;
                default: break;
            }
        }
        // returns the final value
        return stack.peek();
    }



}