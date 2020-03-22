class ListNode {
    public int data;
    public ListNode prev;//前驱
    public ListNode next;//后继
    //new ListNode(10);
    public ListNode(int data) {
        this.data = data;
    }
}

class DoubleList {
    public ListNode head;//头
    public ListNode last;//尾巴

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    public void display() {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    private ListNode searchIndex(int index) {
        if (index < 0 || index > getLength() || this.head == null) {
            return null;
        }
        ListNode cur = this.head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    public int getLength() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == getLength()) {
            addLast(data);
            return;
        }
        ListNode cur = searchIndex(index);
        if (cur == null) {
            return;
        }
        ListNode node = new ListNode(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    //查找是否包含关键字key是否在单链表当中    
    public boolean contains(int key) {
        return false;
    }

    public int remove(int key) {
        int oldData = -1;//存储要删除的数字
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                oldData = cur.data;
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                    return oldData;
                }else {
                    cur.prev.next = cur.next;
                    if (cur != this.last) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                    return oldData;
                }
            }
            cur=cur.next;
        }
        return -1;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        int oldData = -1;//存储要删除的数字
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                oldData = cur.data;
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if (cur != this.last) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }
            }
            cur=cur.next;
        }
    }
    //防止内存泄露
    public void clear(){
        while(this.head!=null){
            ListNode cur=this.head.next;
            this.head.next=null;
            this.head.prev=null;
            this.head=cur;
        }
        this.last=null;
    }
}
