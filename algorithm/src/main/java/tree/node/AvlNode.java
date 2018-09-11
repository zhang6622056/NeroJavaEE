package tree.node;

import tree.node.INode.INode;

/**
 *
 * Created by Nero on 2018/3/12.
 */
public class AvlNode<T> extends BaseNode<T> implements INode<T>{

    private Integer value;
    private Integer height;
    private AvlNode left;
    private AvlNode right;


    public AvlNode(T t){
        initNode(t,null,null,1);
    }


    public AvlNode(T t,AvlNode left,AvlNode right){
        initNode(t,left,right,null);
    }


    private void initNode(T t,AvlNode left,AvlNode right,Integer height){
        this.setValue(t);
        this.left = left;
        this.right = right;
        this.height = height;
    }

    @Override
    public int nodeCompare(INode node) {
        Integer me = (Integer) this.getValue();
        Integer param = (Integer) node.getValue();
        if(me == param){
            System.out.println("eq=========");
            return -1;
        }
        return me > param ? 0 : 1;
    }

    @Override
    public T getValue() {
        return (T) this.value;
    }

    @Override
    public void setValue(T t) {
        this.value = (Integer) t;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public AvlNode getLeft() {
        return left;
    }

    public void setLeft(AvlNode left) {
        this.left = left;
    }

    public AvlNode getRight() {
        return right;
    }

    public void setRight(AvlNode right) {
        this.right = right;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
