package tree.itree;

import tree.node.INode.INode;

/**
 * INero Tree
 * Created by Nero on 2018/3/5.
 */
public interface ITree {


    void insert(INode node);

    boolean contains(INode node);

    void remove();

    INode findMax();

    INode findMin();

    int getNodeSize();

    void printGraph();
}
