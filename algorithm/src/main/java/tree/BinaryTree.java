package tree;

import tree.exception.NodeMisMatchException;
import tree.itree.ITree;
import tree.node.BinaryNode;
import tree.node.INode.INode;

/**
 * Created by Nero on 2018/3/5.
 */
public class BinaryTree<T> implements ITree{

    private BinaryNode root;

    private int SIZE = 0;

    @Override
    public void insert(INode node) {
        if(!(node instanceof BinaryNode)){
            throw new NodeMisMatchException("the node "+ node + "does not match BinaryNode");
        }
        int deep = 0;
        BinaryNode bnode = (BinaryNode) node;

        if(root == null){
            bnode.setDeep(deep);
            root = bnode;
            return;
        }

        insertNode(bnode,root,deep);
    }


    /***
     * 插入节点
     */
    private void insertNode(BinaryNode insertNode,BinaryNode parentNode,int deep){
        if(insertNode.nodeCompare(parentNode) == -1){
            return;
        }
        deep++;
        SIZE++;
        insertNode.setDeep(deep);
        if(insertNode.nodeCompare(parentNode) == 0){
            if(null == parentNode.getRight()){
                parentNode.setRight(insertNode);
                return;
            }else{
                insertNode(insertNode,parentNode.getRight(),deep);
            }
        }

        if(insertNode.nodeCompare(parentNode) == 1){
            if(null == parentNode.getLeft()){
                parentNode.setLeft(insertNode);
                return;
            }else{
                insertNode(insertNode,parentNode.getLeft(),deep);
            }
        }

    }


    @Override
    public boolean contains(INode node) {
        BinaryNode curNode = (BinaryNode) node;
        BinaryNode compareNode = root;

        if(curNode == null){
            return false;
        }
        return myCompare(curNode,compareNode);
    }



    private boolean myCompare(BinaryNode paNode,BinaryNode compareNode){

        boolean res = false;

        if(null == compareNode){
            return false;
        }

        if(paNode.nodeCompare(compareNode) == -1){
            return true;
        }else{
            if(paNode.nodeCompare(compareNode) == 0){
                res= myCompare(paNode, compareNode.getRight());
            }
            if(paNode.nodeCompare(compareNode) == 1){
                res = myCompare(paNode, compareNode.getLeft());
            }
        }
        return res;
    }

    @Override
    public void remove() {

    }

    @Override
    public INode findMax() {
        BinaryNode node = root;
        while(node.getRight() != null){
            node = node.getRight();
        }
        return node;
    }

    @Override
    public INode findMin() {
        BinaryNode node  = root;
        while(node.getLeft() != null){
            node = node.getLeft();
        }
        return node;
    }

    @Override
    public int getNodeSize() {
        return SIZE;
    }

    @Override
    public void printGraph() {
        BinaryNode parent = root;

        if(parent == null){
            System.out.println("root is null");
        }
        System.out.println("root:"+parent.getValue());
        //preNode(parent);
        //inNode(root);
        postNode(parent);
    }


    /****
     * 前序遍历    根左右
     * @param binNode
     */
    private void preNode(BinaryNode binNode){
        System.out.println("deep:"+binNode.getDeep()+"value:"+binNode.getValue());
        if(null != binNode.getLeft()){
            preNode(binNode.getLeft());
        }
        if(null != binNode.getRight()){
            preNode(binNode.getRight());
        }
    }


    /****
     * 中序遍历  左根右
     * @param binNode
     */
    private void inNode(BinaryNode binNode){
        if(binNode.getLeft() != null){
            inNode(binNode.getLeft());
        }
        System.out.println("deep:"+binNode.getDeep()+"value:"+binNode.getValue());
        if(binNode.getRight() != null){
            inNode(binNode.getRight());
        }
    }


    /***
     * 后序遍历   右根左
     */
    private void postNode(BinaryNode binNode){
        if(binNode.getLeft() != null){
            inNode(binNode.getLeft());
        }
        if(binNode.getRight() != null){
            inNode(binNode.getRight());
        }
        System.out.println("deep:"+binNode.getDeep()+"value:"+binNode.getValue());
    }

}
