package tree.node;

import tree.itree.ITree;
import tree.itree.ITreeInteger;
import tree.node.INode.INode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Nero on 2018-09-11.
 */
public class AvlTreeInteger implements ITreeInteger{
    public static final int QIANXU = 1;
    public static final int ZHONGXU = 2;
    public static final int HOUXU = 3;
    public static final int CENGJI = 4;


    private AvlNode<Integer> root;
    private int size;


    public AvlTreeInteger() {
    }
    public AvlTreeInteger(AvlNode<Integer> root) {
        this.root = root;
    }

    private void initRoot(Integer val){
        AvlNode<Integer> avlNode = new AvlNode<Integer>(val);
        this.root = avlNode;
        System.out.println(this.root.getValue());
    }

    @Override
    public void insert(Integer val) throws Exception {
        if(null == root){
            initRoot(val);
            size++;
            return;
        }

        if(contains(val)) throw new Exception("The value is already exist!");

        insertNode(this.root,val);
        size++;
    }


    private AvlNode createSingleNode(Integer val){
        return new AvlNode(val);
    }

    /**
     * 递归插入
     * parent == null 到最底部插入前节点判断情况
     * @param parent
     * @param val
     * @return
     */
    private AvlNode<Integer> insertNode(AvlNode<Integer> parent,Integer val){
        if(parent == null){
           return createSingleNode(val);
        }
        if(val < parent.getValue()){
            parent.setLeft(insertNode(parent.getLeft(),val));
            if(height(parent.getLeft()) - height(parent.getRight()) > 1){ //不平衡
                Integer compareVal = (Integer) parent.getLeft().getValue();
                if(val < Integer.valueOf(compareVal)){  //LL
                    parent = leftLeftRotate(parent);
                }else{                                  //LR
                    parent = leftRightRotate(parent);
                }
            }
        }
        if(val > parent.getValue()){
            parent.setRight(insertNode(parent.getRight(),val));
            if(height(parent.getRight()) - height(parent.getLeft()) > 2){   //不平衡
                Integer compareVal = (Integer) parent.getLeft().getValue();
                if(val > compareVal){       //RR
                    parent = rightRightRotate(parent);
                }else{                  //RL
                    parent = rightLeftRotate(parent);
                }
            }
        }

        parent.setHeight((maxHeight(parent.getLeft(),parent.getRight()))+1);
        return parent;
    }


    /***
     * 左左旋转模型
     * @param node  旋转之前的parent node 节点
     * @return  旋转之后的parent node节点
     */
    private AvlNode<Integer> leftLeftRotate(AvlNode node){
        AvlNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);

        //由此node的高度降低了，newRoot的高度提高了。
         //newRoot的高度由node的高度而来
        node.setHeight(maxHeight(node.getLeft(),node.getRight())+1);
        newRoot.setHeight(maxHeight(newRoot.getLeft(),newRoot.getRight())+1);
        return newRoot;
    }


    /***
     * 右右旋转模型
     * @param node
     * @return
     */
    private AvlNode rightRightRotate(AvlNode node){
        AvlNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);

        //由此node的高度降低了，newRoot的高度提高了。
        //newRoot的高度由node的高度而来
        node.setHeight(maxHeight(node.getLeft(),node.getRight()));
        newRoot.setHeight(maxHeight(newRoot.getLeft(),newRoot.getRight()));
        return newRoot;
    }

    /**
     * 左右模型，先右右，再左左
     * @param node
     * @return
     */
    private AvlNode leftRightRotate(AvlNode node){
        node.setLeft(rightRightRotate(node.getLeft()));
        return leftLeftRotate(node);
    }

    /***
     * 右左模型，先左左，在右右
     * @param node
     * @return
     */
    private AvlNode rightLeftRotate(AvlNode node){
        node.setRight(leftLeftRotate(node.getRight()));
        return rightRightRotate(node);
    }




    /***
     * 求左右子节点最大高度
     * @param left
     * @param right
     * @return
     */
    private int maxHeight(AvlNode<Integer> left,AvlNode<Integer> right){
        return height(left) > height(right) ? height(left)  : height(right);
    }

    /***
     * 求一个节点的高度
     * @param t
     * @return
     */
    private int height(AvlNode t){
        return null == t ? 0 : t.getHeight();
    }


    @Override
    public boolean contains(Integer val) {
        AvlNode<Integer> curNode = root;
        if(null == curNode) return false;

        while(null != curNode){
            if(val > curNode.getValue()){
                curNode = curNode.getRight();
            }else if(val < curNode.getValue()){
                curNode = curNode.getLeft();
            }else{
                return true;
            }
        }
        return false;
    }





    @Override
    public void remove() {




    }

    @Override
    public INode findMax() {
        if(null == root) return null;

        AvlNode temp = root;
        while(null != temp.getRight()){
            temp = temp.getRight();
        }
        return temp;
    }

    @Override
    public INode findMin() {
        if(null == root) return null;
        AvlNode temp = root;
        while(null != temp.getLeft()){
            temp = temp.getLeft();
        }
        return temp;
    }

    @Override
    public int getNodeSize() {
        return size;
    }

    @Override
    public void printGraph(int style) {
        if(root == null){
            return;
        }

        if(style == 1){
            xianxu(root);
        }else if(style == 2){
            zhongxu(root);
        }else if(style == 3){
            houxu(root);
        }else if(style == 4){
            List a = new ArrayList<>();
            a.add(root);
            cengji(a);
        }
    }

    /***
     * 前序编译
     * 1-根节点
     * 2-左节点
     * 3-右节点
     * 根左右
     * @param parent
     */
    private void xianxu(AvlNode parent){
        System.out.println(parent.getValue());
        if(null != parent.getLeft()){
            xianxu(parent.getLeft());
        }
        if(null != parent.getRight()){
            xianxu(parent.getRight());
        }
    }

    /***
     * 中序遍历
     * 左节点
     * 根节点
     * 右节点
     *
     *
     * 左根右
     * @param parent
     */
    private void zhongxu(AvlNode parent){
        if(null != parent.getLeft()){
            zhongxu(parent.getLeft());
        }
        System.out.println(parent.getValue());

        if(null != parent.getRight()){
            zhongxu(parent.getRight());
        }
    }


    /***
     * 后续遍历
     * 左右根
     * 左节点
     * 右节点
     * 根节点
     */
    private void houxu(AvlNode parent){
        if(null != parent.getLeft()){
           houxu(parent.getLeft());
        }
        if(null != parent.getRight()){
            houxu(parent.getRight());
        }
        System.out.println(parent);
    }

    /***
     * 层级遍历
     * @param parent
     */
    private void cengji(List<AvlNode> parent){
        if(null == parent || parent.size() == 0) return;

        //打印当前层
        List<AvlNode> avlNodes = new ArrayList<AvlNode>();
        int k = 0;
        for(int i = 0 ; i < parent.size() ; i++){
            AvlNode currentNode = parent.get(i);
            System.out.println(currentNode.getValue()+",");
            if(null != currentNode.getLeft()){
                avlNodes.add(currentNode.getLeft());
                k++;
            }
            if(null != currentNode.getRight()){
                avlNodes.add(currentNode.getRight());
                k++;
            }
        }
        System.out.println("--------------------------");
        cengji(avlNodes);
    }




}
