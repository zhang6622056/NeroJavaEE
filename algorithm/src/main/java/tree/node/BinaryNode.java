package tree.node;

import tree.node.INode.INode;

/**
 * 二叉树node
 * Created by Nero on 2018/3/5.
 */
public class BinaryNode<T> extends BaseNode<T> implements INode<T>{

    private BinaryNode left;
    private BinaryNode right;

    private T t;

    public T getValue(){
        return t;
    }

    @Override
    public void setValue(Object o) {
        this.t = (T) o;
    }


    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }


    @Override
    public int nodeCompare(INode node) {
        Integer me = (Integer) t;
        Integer param = (Integer) node.getValue();
        if(me == param){
            System.out.println("eq=========");
            return -1;
        }
        return me > param ? 0 : 1;
    }
}
