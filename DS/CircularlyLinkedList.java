package DS;

public class CircularlyLinkedList<E> {
    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {}

    public int size() { return size; }

    public boolean isEmpty() {return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getData();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getData();
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e);
        if (isEmpty()) {
            tail = newNode;
            tail.setNext(tail);
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public String toString() {
        Node<E> head = tail.getNext();
        String result = "";
        for (int i = 0; i < size; i++) {
            result += head.getData() + ", ";
            head = head.getNext();
        }
        return result + "tail";
    }
    public void addLast(E e) {
        if(isEmpty()) addFirst(e);
        else {
            tail.setNext(new Node<E>(e, tail.getNext()));
            tail = tail.getNext();
            size++;
        }
    }

    public E removeFirst() {
        E removed = tail.getNext().getData();
        tail.setNext(tail.getNext().getNext());
        return removed;
    }

    public E removeLast() {
        Node<E> pointer = tail;
        for(int i = 0; i < size - 1; i++) {
            pointer = pointer.getNext();
        }
        E removed = tail.getNext().getData();
        pointer.setNext(tail.getNext());
        tail = pointer;
        return removed;
    }

    public static void main(String[] args) {
        CircularlyLinkedList<Integer> listFull = new CircularlyLinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            listFull.addFirst(i);
        }
        System.out.println(listFull);
        CircularlyLinkedList<Integer> listEmpty = new CircularlyLinkedList<Integer>();
        CircularlyLinkedList<Integer> listOne = new CircularlyLinkedList<Integer>();
        listOne.addFirst(0);
        //Test removeLast() 
        System.out.println(listEmpty.removeLast());
        System.out.println(listOne.removeLast());
        System.out.println(listFull.removeLast());
        System.out.println(listEmpty);
        System.out.println(listOne);
        System.out.println(listFull);
    }
}
