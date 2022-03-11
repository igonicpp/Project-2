
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
    public void clear() {
        topNode == null;
    }
    // implementation of the interface
    private class Node {
        private T data;
        private Node next;


        public Node(T newEntry, Node topNode) {

        }

        public Node getNextNode() {

        }

        public T getData(){
        }
    }
    }



        // constructors and get and set methods



    /*
        private Node(T dataPortion){
            this(dataPortion, null);
        }
        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }


        private T getData(){
            return data;
        }


        private void setData(T newData){
            data = newData;
        }


        private Node getNextNode(){
            return next;
        }



        private void setNextNode(Node nextNode){
            next = nextNode;
         */

    }
}