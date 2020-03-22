package practise;

import java.util.Arrays;

public class MyPriorityQueue {
    private int[] array;
    private int size;
    public MyPriorityQueue(){
        //默认的构造方法，底层容量为11
        array = new int[11];
        size = 0;
    }
    public MyPriorityQueue(int initCapacity){
        if(initCapacity < 1){
            //标准库：抛出一个非法参数的异常
            initCapacity = 11;
        }
        array = new int[initCapacity];
        size = 0;
    }
    //标准库中没有该接口-->标准库中采用集合来构造优先级队列
    public MyPriorityQueue(int[] arr){
        array = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            array[i] = arr[i];
        }
        size = array.length;
        //将array中的元素进行调整，让其满足小堆的性质
        int node = (arr.length - 2) >> 1;
        for(;node >= 0;node--){
            shiftDown(node);
        }
    }
    int peek(){
        //标准库中，如果优先级队列是空，无法获取堆顶元素，返回null
        return array[0];
    }
    boolean offer(int x){
        //检测是否需要扩容
        if(size >= array.length){
            grow();
        }
        //将x尾插到数组中
        array[size++] = x;
        shiftUp(size - 1);
        return true;
    }
    int poll(){
        int ret = array[0];
        swap(0,size - 1);
        size--;
        shiftDown(0);
        return ret;
    }
    boolean isEmpty(){
        return 0 == size;
    }

    void clear(){
        size = 0;
    }
    private void shiftDown(int parent) {
        int size = array.length;
        //使用child标记parent的左孩子
        //默认标记左孩子，因为parent可能只有左孩子没有右孩子
        int child = parent * 2 + 1;
        while (child < array.length) {
            //child标记较小的孩子
            //利用左右孩子进行比较时，必须保证右孩子存在
            if (child + 1 < size && array[child + 1] < array[child]) {
                child += 1;
            }
            //检测双亲是否比较小的孩子大
            if (array[child] < array[parent]) {
                //说明双亲不满足小堆的性质，将child与parent的元素交换
                swap(child, parent);
                //parent较大的元素向下移动，可能会导致子树不满足堆的性质
                parent = child;
                child = parent * 2 + 1;
            } else {
                //双亲已经满足堆的性质
                return;
            }
        }
    }
    private void shiftUp(int child){
        int parent = (child - 1) >> 1;
        while(child != 0){
            if(array[child] < array[parent]){
                swap(child, parent);
                child = parent;
                parent = (child - 1) >> 1;
            }
            else{
                return;
            }
        }
    }
    private void swap(int child, int parent){
        int temp = array[child];
        array[child] = array[parent];
        array[parent] = temp;
    }

    private void grow(){
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + ((oldCapacity < 64) ? (oldCapacity + 2) : oldCapacity >> 1);
        array = Arrays.copyOf(array, newCapacity);
    }

    public static void main(String[] args) {
        int[] array = {5,3,7,1,4,6,8,0,2};
        MyPriorityQueue q = new MyPriorityQueue(array);
        q.offer(9);
        System.out.println(q.peek());
        System.out.println(q.size);
        q.offer(-1);
        System.out.println(q.peek());
        q.poll();
        System.out.println(q.peek());
        q.clear();
        if(q.isEmpty()){
            System.out.println("空");
        }
        else{
            System.out.println("非空");
        }
    }
}


