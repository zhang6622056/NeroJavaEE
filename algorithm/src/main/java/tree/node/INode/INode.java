package tree.node.INode;

/**
 * Created by Nero on 2018/3/5.
 */
public interface INode<T> {

    /****
     * 0 this > param
     * 1 param > this
     * @param node
     * @return
     */
    int nodeCompare(INode node);


    /****
     * return Node Value
     * @return
     */
    T getValue();
    /***
     * set the node value
     * @return
     */
    void setValue(T t);

}
