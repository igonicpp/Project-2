import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>{
    private Node topNode;

    public LinkedStack(){
        topNode = null;
    }

// implementation of the interface
    @Override
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }

    @Override
    public T pop() {
       T top = peek();
       topNode = topNode.getNextNode();
       return top;
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();


    }

    @Override
    public boolean isEmpty() {
       return topNode == null;
    }

    @Override
    public void clear(){
        topNode = null;
    }

    // implementation of the interface
    private class Node {
        private T data;
        private Node next;


    public Node(T newEntry, Node atopNode){
        next = atopNode;
        data = newEntry;

    }

    public Node getNextNode(){
        return next;
    }
    public Node setNextNode(){
        return next;
    }

    public T getData(){
        return data;
    }


    }
}