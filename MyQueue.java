package java;
//带头结点的单链表
class Node<E>{
    public Node next;
    public E data;

    public Node(E e){
        next = null;
        data = e;
    }
    public Node()
    {
        next = null;
    }
}
public class MyQueue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    MyQueue()
    {
        front = rear = new Node<E>();
        size = 0;
    }
    boolean offer(E e)
    {
        Node<E> node = new Node<>();
        rear = rear.next;
        return true;
    }
    E poll()
    {
        if(isEmpty())
        return null;

        E ret = (E) front.next.data;
        front.next = front.next.next;
        size--;
        return ret;
    }
    E peek()
    {
        if(isEmpty())
            return null;
        return (E)front.next.data;
    }
    int size()
    {
        return size;
    }
    boolean isEmpty()
    {
        return 0 == size;
    }
}
