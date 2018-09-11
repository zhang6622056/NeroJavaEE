package tree;

import tree.itree.ITree;
import tree.node.AvlNode;
import tree.node.INode.INode;

/**
 * AVL tree
 * Created by Nero on 2018/3/12.
 */
public class AvlTree<T> implements ITree{

    private AvlNode<T> root;

    private int size = 0;



    @Override
    public void insert(INode node) {
        AvlNode avlNode = (AvlNode) node;
        System.out.println(avlNode.getValue());
        if(null == root){
            root = avlNode;
            size++;
            return;
        }
        root = insertNode(avlNode,root);
    }


    /*****
     * do insert .
     * if unbalanced after u insert the newnode
     * compare the sub node of parent with insertnode to makesure the unbalanced style.
     * @param insertNode
     * @param parentNode
     * @return
     */
    private AvlNode insertNode(AvlNode insertNode,AvlNode parentNode){
        if(null == parentNode){
            size++;
            return insertNode;
        }

        if(insertNode.nodeCompare(parentNode) == 1){    //插入到左边
                parentNode.setLeft(insertNode(insertNode,parentNode.getLeft()));
                //查看冲突关系
                if(height(parentNode.getLeft()) - height(parentNode.getRight()) == 2){  //不平衡
                    if(insertNode.nodeCompare(parentNode.getLeft()) == 1){  //LL
                        parentNode = leftLeftRotate(parentNode);
                    }else{  //LR
                        parentNode = leftRightRotate(parentNode);
                    }
                }
        }else if(insertNode.nodeCompare(parentNode) == 0){  //插入到右边
                parentNode.setRight(insertNode(insertNode,parentNode.getRight()));
                if(height(parentNode.getRight()) - height(parentNode.getLeft()) == 2){  //不平衡
                    if(insertNode.nodeCompare(parentNode.getRight()) == 1){  //RL
                        parentNode = RightLeftRotate(parentNode);
                    }else{  //RR
                        parentNode = rightRightRotate(parentNode);
                    }
                }
        }else{  //已存在
            //do nothing.
        }

        parentNode.setHeight(maxHeight(parentNode.getLeft(),parentNode.getRight())+1);
        return parentNode;
    }


    /****
     * count the node height.
     * if null return 0
     * @param avlNode
     * @return
     */
    private int height(AvlNode avlNode){
       return avlNode == null ? 0 : avlNode.getHeight();
    }


    /***
     * RR类型，左旋一次
     * @param node
     * @return
     */
    private AvlNode rightRightRotate(AvlNode node){
        AvlNode topNode = node.getRight();
        node.setRight(topNode.getLeft());
        topNode.setLeft(node);

        topNode.setHeight(maxHeight(topNode.getLeft(),topNode.getRight()));
        node.setHeight(maxHeight(node.getLeft(),node.getRight()));
        return topNode;
    }

    /****
     * LL 类型 ，右旋一次
     * @param node
     * @return
     */
    private AvlNode leftLeftRotate(AvlNode node){
        AvlNode newTop = node.getLeft();
        node.setLeft(newTop.getRight());
        newTop.setRight(node);

        //重新求高度
        node.setHeight(maxHeight(node.getLeft(),node.getRight()));
        newTop.setHeight(maxHeight(newTop.getLeft(),newTop.getRight()));

        return newTop;
    }


    /****
     * frist left then right.
     * if right then rotate left. the same else.
     * @param avlNode
     * @return
     */
    private AvlNode leftRightRotate(AvlNode avlNode){
        avlNode.setLeft(rightRightRotate(avlNode.getLeft()));
        avlNode = leftLeftRotate(avlNode);
        return avlNode;
    }


    /****
     * right left rotate
     * @param avlNode
     * @return
     */
    private AvlNode RightLeftRotate(AvlNode avlNode){
        avlNode.setRight(leftLeftRotate(avlNode.getRight()));
        avlNode = rightRightRotate(avlNode);
        return avlNode;
    }

    private int maxHeight(AvlNode left,AvlNode right){
        return height(left) > height(right) ? height(left) : height(right);
    }


    @Override
    public boolean contains(INode node) {
        return false;
    }

    @Override
    public void remove() {

    }

    @Override
    public INode findMax() {
        return null;
    }

    @Override
    public INode findMin() {
        return null;
    }

    @Override
    public int getNodeSize() {
        return size;
    }

    @Override
    public void printGraph() {
        leftMidRight(root);
    }

    public AvlNode<T> getRoot() {
        return root;
    }

    public void setRoot(AvlNode<T> root) {
        this.root = root;
    }


    /****
     * left middle right
     * @param avlNode
     */
    private void leftMidRight(AvlNode avlNode){
        if(null != avlNode.getLeft()){
            leftMidRight(avlNode.getLeft());
        }
        System.out.println(avlNode.getValue() + "height:" + avlNode.getHeight());
        if(null != avlNode.getRight()){
            leftMidRight(avlNode.getRight());
        }
    }










}
