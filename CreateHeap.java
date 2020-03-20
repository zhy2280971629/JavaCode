public class CreateHeap {
    public static void shiftDown(int[] arr, int parent){
        //child标记parent的左孩子
        int child = parent * 2 + 1;
        int size = arr.length;
        while(child < size){
            //检测parent是否需要与较小的孩子交换
            //如果能找到parent较小的孩子
            if(child + 1 < size && arr[child + 1] < arr[child] ){
                child += 1;//child标记的是较小的孩子
            }
            //较小的孩子child已经找到，检测是否需要与双亲进行交换
            //如果较小的孩子比双亲还小，说明双亲已经不满足小堆的性质
            if(arr[child] < arr[parent]){
                swap(arr,child, parent);
                //大的元素往下移动，可能会导致子树不满足小堆的性质
                //如果不满足小堆性质，需要对其子树进行调整
                parent = child;
                child = parent * 2 + 1;
            }
            else{
                return;
            }
        }
    }
    public static void swap(int[] arr, int child, int parent){
        int temp = arr[child];
        arr[child] = arr[parent];
        arr[parent] = temp;
    }
    public static void createHeap(int[] array){
        //找到倒数第一个非叶子节点，即最后一个节点的双亲
        int node = (array.length - 2) >> 1;
        for(;node >= 0;node--){
            shiftDown(array, node);
        }
    }
}
