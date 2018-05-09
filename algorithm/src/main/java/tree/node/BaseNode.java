package tree.node;

import tree.node.INode.INode;

/**
 *
 * Created by nero on 2018/3/5.
 */
public abstract class BaseNode<T>{

    private String nodeName;
    private Integer nodeType;
    private INode parentNode;
    private int Deep;



    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public INode getParentNode() {
        return parentNode;
    }

    public void setParentNode(INode parentNode) {
        this.parentNode = parentNode;
    }

    public int getDeep() {
        return Deep;
    }

    public void setDeep(int deep) {
        Deep = deep;
    }
}
