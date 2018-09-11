package tree.itree;

import tree.node.INode.INode;

/**
 * Created by admin on 2018-09-11.
 */
public interface ITreeInteger {


    void insert(Integer val) throws Exception;

    boolean contains(Integer val);

    void remove();

    INode findMax();

    INode findMin();

    int getNodeSize();

    void printGraph(int style);

}
