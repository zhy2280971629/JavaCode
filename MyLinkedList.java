package practise;
public class MyLinkedList {
    public Node head;
    public int size;
    //结点类
    private class Node{
        int val;
        Node next;
        public Node(int val){
            val = val;
            next = null;
        }
    }
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if(index >= size || index < 0)
        {
            return -1;
        }
        Node cur = head;
        int i = -1;
        while(i < index){
            cur = cur.next;
            i++;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        Node cur = head;
        int i = -1;
        if(index >= 0 && index <= size){
            Node node = new Node(val);
            if(index == 0){
                node.next = head;
                head = node;
            }else{
                while(i < index-1){
                    cur = cur.next;
                    i++;
                }
                node.next = cur.next;
                cur.next = node;
            }
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index >= 0 && index < size){
            if(index == 0){
                head.next = head.next.next;
            }else{
                Node cur = head;
                int i = -1;
                while(i < index - 1){
                    cur = cur.next;
                    i++;
                }
                cur.next = cur.next.next;
            }
            size--;
        }
    }

    public static void main(String[] args) {

    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
