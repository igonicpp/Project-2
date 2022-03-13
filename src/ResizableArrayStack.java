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

        @SupressWarnings("unchecked")
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
        if(isEmpty)
            throw new EmptyStackEXception();
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
}
