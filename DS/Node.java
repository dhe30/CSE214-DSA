package DS;
public class Node<E> {
    private E value = null;
    private Node<E> next = null; 

    public Node() {}

    public Node(E value) {
        this.value = value;
        next = null;
    }

    public Node(E value, Node<E> next) {
        this(value);
        this.next = next;
    }

    public E getData() {
        return value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}