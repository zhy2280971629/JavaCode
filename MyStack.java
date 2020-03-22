package java;
import java.util.Stack;
class MyStack1<E>
{
    private E[] array =(E[]) new Object[100];
    private int size = 0;

    public void push(E e){
        if(size == 100)
            return;

        array[size++] = e;
    }

    public E pop(){
        if(empty())
            return null;
        E e = array[size - 1];
        size--;
        return e;
    }

    E peek(){
        if(empty())
            return null;
        return array[size - 1];
    }

    boolean empty(){
        return 0 == size;
    }

}
public class MyStack {
    public static void main(String[] args) {
        Stack<String> s = new Stack();
        System.out.println(s.size());
        System.out.println(s.empty());
        s.push("111");
        s.push("222");
        s.push("333");
        System.out.println(s.peek());

    }
}
