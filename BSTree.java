package javastructure;

public class BSTree {
    public static class BSTNode{
        BSTNode left = null;
        BSTNode right = null;
        int val;
        public BSTNode(int val){
            this.val = val;
        }
    }
    private BSTNode root = null;
    boolean contains(int val){
        BSTNode cur = root;
        while(cur != null){
            if(val == cur.val){
                return true;
            }
            else if(val < cur.val){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return false;
    }

    //将val插入到二叉搜索树中，插入成功返回true，否则返回false
    public boolean put(int val){
        if(null == root){
            root = new BSTNode(val);
            return true;
        }
        BSTNode cur = root;
        BSTNode parent = null;
        while(cur != null){
            parent = cur;
            if(val < cur.val){
                cur = cur.left;
            }
            else if(val > cur.val){
                cur = cur.right;
            }
            else{
                return false;
            }
        }
        //找到带插入结点的位置 ---》插入新节点
        //将新节点插到parent的左侧或右侧
        cur = new BSTNode(val);
        if(val < parent.val){
            parent.left = cur;
        }
        else{
            parent.right = cur;
        }
        return true;
    }

    boolean remove(int val){
        if(null == root){
            return false;
        }
        //非空--找待删除节点的位置
        BSTNode cur = root;
        BSTNode parent = null;
        while(cur != null){
            if(val == cur.val){
                break;
            }
            else if(val < cur.val){
                parent = cur;
                cur = cur.left;
            }
            else{
                parent = cur;
                cur = cur.right;
            }
        }
        //没有找到
        if(cur == null){
            return false;
        }
        //已经找到待删除节点在树中的位置
        //必须要对cur的孩子节分点分情况
        //1.没有孩子
        //2.只有左孩子
        //3.只有右孩子
        //4.左右孩子均存在
        if(null == cur.left){
            //cur只有右孩子
            if(null == parent){
                //cur双亲不存在
                root = cur.right;
            }
            else{
                //双亲存在
                if(cur == parent.left){
                    parent.left = cur.right;
                }
                else{
                    parent.right = cur.right;
                }
            }
        }
        else if(null == cur.right){
            //cur只有左孩子
            if(null == parent){
                //双亲不存在
                root = cur.left;
            }
            else{
                //双亲存在
                if(parent.right == cur){
                    parent.right = cur.left;
                }
                else{
                    parent.left = cur.left;
                }
            }
        }
        else{
            //cur节点的左右孩子均存在--不能直接删除
            //在cur子树中找一个替代节点删除
            //方式一：在其右子树中找最小的节点:即最左侧节点
            //方式二：在其左子树中找最大的节点：及最右侧节点
            BSTNode del = cur.right;
            parent = cur;
            while(null != del.left){
                parent = del;
                del = del.left;
            }
            //替代节点找到
            cur.val = del.val;
            //删除替代节点
            if(del == parent.left){
                parent.left = del.right;
            }
            else{
                parent.right = del.right;
            }
        }
        return true;
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(BSTNode root){
        if(null != root){
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }
    }
    //最左侧节点--最小的节点
    public int mostLeft(){
        if(null == root){
            //抛异常--空指针异常
        }
        BSTNode cur = root;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur.val;
    }

    //最右侧节点
    public int mostRight(){
        if(null == root){
            //抛异常--空指针异常
        }
        BSTNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        return cur.val;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 1, 7, 8, 2, 6, 0, 9};
        BSTree t = new BSTree();
        for(int e : array){
            t.put(e);
        }
        t.inOrder();
        System.out.println(t.mostLeft());
        System.out.println(t.mostRight());
    }

}
