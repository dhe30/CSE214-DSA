public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {}

    public int size() { return size; }

    public boolean isEmpty() {return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return head.getData();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getData();
    }

    public void addFirst(E e) {
        head = new Node<E>(e, head);
        if (size == 0) tail = head; 
        size++;
    }

    public String toString() {
        Node<E> pointer = head;
        String result = "";
        while (pointer != null) {
            result += pointer.getData() + ", ";
            pointer = pointer.getNext();
        }
        return result + "tail";
    }
    public void addLast(E e) {
        // Empty List: set tail as newNode, set head as newNode 
        // Else: set tail.next as newNode, set tail as newNose
        Node<E> newNode = new Node<E>(e);
        if (isEmpty()) head = newNode;
        else tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public E removeFirst() {
        // Size = 1: set both tail and head as null 
        // Size > 1: set head as head.next
        if (isEmpty()) return null;
        E removed = head.getData();
        head = head.getNext();
        if (size == 1) tail = null;
        size--;
        return removed;
    }

    public E removeLast() {
        // Size = 0: do nothing 
        // Size = 1: removeFirst() 
        // Size > 2: pointer.next.next = null; pointer.next = null; tail = pointer
        E removed;
        if (size < 2) removed = removeFirst();
        else {
            Node<E> pointer = head;
            while(pointer.getNext().getNext() != null) {
                pointer = pointer.getNext();
            }
            removed = pointer.getNext().getData();
            pointer.setNext(null);
            tail = pointer;
        }
        size--;
        return removed;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> listFull = new SinglyLinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            listFull.addFirst(i);
        }
        System.out.println(listFull);
        SinglyLinkedList<Integer> listEmpty = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Integer> listOne = new SinglyLinkedList<Integer>();
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