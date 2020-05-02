package javastructure;

//哈希桶---> 数组 + 链表实现的---> 可以用来帮助用户快速定位要将元素插入到那个链表来组织链表
//数组中存储的元素实际为元素的引用
public class HashBucket {
    public static class Node{
        int key;
        int value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    //哈希桶中的成员数据
    Node[] table;
    int capacity;//表格的容量--》桶的个数
    int size;//有效元素的个数
    double loadFact = 0.75;
    public HashBucket(int initCap){
        //保证哈希桶的容量至少为10
        capacity = initCap;
        if(initCap < 10){
            capacity = 10;
        }
        table = new Node[capacity];
        size = 0;
    }
    public int put(int key, int value){
        //1.通过哈希函数，计算key所在的桶号
        int bucketNo = hashFunc(key);
        //2.在bucketNo桶中检测key是否存在
        //检测方式：遍历链表
        Node cur = table[bucketNo];
        while(null != cur){
            if(cur.key == key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
            cur = cur.next;
        }
        //3.key不存在，将key-value插入到哈希桶中
        cur = new Node(key, value);
        cur.next = table[bucketNo];
        table[bucketNo] = cur;
        size++;
        return value;
    }
    //将哈希桶中为key的键值对删除
    public boolean remove(int key){
        //1.通过哈希函数计算key的桶号
        int bucketNo = hashFunc(key);
        //2.在bucketNo桶中找到key对应的节点，找到后删除
        Node cur = table[bucketNo];
        Node prev = null;
        while(null != cur){
            if(cur.key == key){
                //找到与key所对应的节点，将其删除
                if(null == prev){
                    //删除的节点刚好是第一个节点
                    table[bucketNo] = cur.next;
                }
                else{
                    //删除其他节点
                    prev.next = cur.next;
                }
                --size;
                return true;
            }
            else{
                prev = cur;
                cur = cur.next;
            }
        }
        return false;
    }

    public boolean containsKey(int key){
        //1.计算key所在的桶号
        int bucketNo = hashFunc(key);
        //2.在bucketNo桶中找key
        Node cur = table[bucketNo];
        while(null != cur){
            if(cur.key == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean containsValue(int value){
        for(int bucketNo = 0; bucketNo < capacity; bucketNo++){
            Node cur = table[bucketNo];
            while(null != cur){
                if(cur.value == value){
                    return true;
                }
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return 0 == size;
    }

    private void resize(){
        //装载因子超过0.75时进行扩容，按照2倍的方式进行扩容
        if(size*10 / capacity > loadFact*10){
            int newCap = capacity * 2;
            Node[] newTable = new Node[newCap];

            //将table中所有的节点搬到newTable中
            for(int i = 0; i < capacity; i++){
                Node cur = table[i];
                //将table中i号桶中所对应链表中所有的节点插入到newTable中
                while(null != cur){
                    table[i] = cur.next;
                    //将cur节点插入到newTable中
                    //1.计算cur在newTable中的桶号
                    int bucketNo = cur.key % newCap;
                    //2.将cur插入到newTable中
                    cur.next = newTable[bucketNo];
                    newTable[bucketNo] = cur;

                    //取table中i号捅的下一个节点
                    cur = table[i];
                }
            }
            table = newTable;
            capacity = newCap;
        }
    }

    private int hashFunc(int key){
        return key % capacity;
    }

    public void print(){
        for(int bucketNo = 0; bucketNo < capacity; bucketNo++){
            System.out.printf("table[%d]-->", bucketNo);
        }
    }
    
}
