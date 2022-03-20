public interface StackInterface<T> {
    /**
     * Adds newEntry to top of the stack.
     * @param newEntry The object to be added to the stack.
     */

    public void push(T newEntry);

    /**
     * Remove and returns this stack's top entries.
     * @return The object at top of the stack.
     * @throws if stack is empty throw EmptyStackException.
     */

    public T pop();

    /** Retrieve this stack's top entry.
     * @return The object is top of the stack.
     * @throws if stack is empty throw EmptyStackException.
     */

    public T peek();

    /** Check if the stack is empty.
     * @return True when the back is empty.
     */

    public boolean isEmpty();

    /** remove all entries from the stack*/
    public void clear();
}
