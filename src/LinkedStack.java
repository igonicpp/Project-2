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
    private static boolean checkPrecedence(char a, char b){
        boolean precedence = false;
        switch(a){
            case '+': case'-':
                if(b == '^' || b == '*' || b == '/'){
                    precedence = false;
                }
                else{
                    precedence = true;
                }
            case '*': case'/':
                if(b == '^'){
                    precedence = false;
                }
                else{
                    precedence = true;
                }
            default: precedence = false;
        }
        return precedence;
    }
    public static String toPostFix(String infix){
        LinkedStack<Character> stack = new LinkedStack<Character>();
        String postfix = "";
        String copyInfix = infix;
        char nextCharacter;
        char topOperator;
        while(copyInfix.length() > 0){
            nextCharacter = copyInfix.charAt(0);
            if(copyInfix.length() > 1){
                copyInfix = copyInfix.substring(1);
            }
            if(copyInfix.length() == 1){
                copyInfix = "";
            }
            switch(nextCharacter){
                case 'a': case 'b': case 'c': case 'd': case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':
                case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':
                case 'v':case 'w':case 'x':case 'y':case 'z':
                    postfix += nextCharacter;
                    break;
                case '^':
                    stack.push(nextCharacter);
                    break;
                case '+': case '-': case '*': case '/':
                    while(!stack.isEmpty() && checkPrecedence(nextCharacter, stack.peek())){
                        postfix += nextCharacter;
                        stack.pop();
                    }
                    stack.push(nextCharacter);
                    break;
                case '(':
                    stack.push(nextCharacter);
                    break;
                case ')':
                    topOperator = stack.pop();
                    while(topOperator != '('){
                        postfix += topOperator;
                        topOperator = stack.pop();
                    }
                    break;
                default: break;
            }
        }
        while(!stack.isEmpty()){
            topOperator = stack.pop();
            postfix += topOperator;
        }

        return postfix;
    }
}