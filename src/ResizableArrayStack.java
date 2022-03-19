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

    public ResizableArrayStack(int initialCapacity){
        integrityOK = false;
        checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = 1;
        integrityOK = true;
    }



    //interfaces methods


    @Override
    public void push(T newEntry) {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }
    private void ensureCapacity(){
        if(topIndex >= stack.length -1){
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
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
    private void checkIntegrity(){
        if (!integrityOK){
            throw new SecurityException("ArrayStack object is corrupt.");
        }
    }
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack whose " +
                    "capacity exeeds allowed " +
                    "maximum of " + MAX_CAPACITY);
    }

    public static double evaluatePostFix(String postfix){
        ResizableArrayStack<Double> stack = new ResizableArrayStack<Double>();
        char nextCharacter;
        double operandOne;
        double operandTwo;
        double result = 0.0;
        String copyPostFix = postfix;
        while(copyPostFix.length() > 0){
            nextCharacter = copyPostFix.charAt(0);
            if(copyPostFix.length() > 1){
                copyPostFix = copyPostFix.substring(1);
            }
            if(copyPostFix.length() == 1){
                copyPostFix = "";
            }
            switch(nextCharacter){
                case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8':case '9': 
                    stack.push((double) nextCharacter);
                    break;
                case'+': case'-': case '*': case '/': case '^':
                    operandOne = stack.pop();
                    operandTwo = stack.pop();
                    if(nextCharacter == '+'){
                        result = (double) (operandOne + operandTwo);
                    }
                    if(nextCharacter == '-'){
                        result = (double) (operandOne - operandTwo);
                    }
                    if(nextCharacter == '*'){
                        result = (double) (operandOne * operandTwo);
                    }
                    if(nextCharacter == '/'){
                        result = (double) (operandOne / operandTwo);
                    }
                    if(nextCharacter == '^'){
                        result = (double) (Math.pow(operandOne, operandTwo));
                    }
                    stack.push(result);
                    break;
                default: break;
            }
        }
        return stack.peek();
    }



}
