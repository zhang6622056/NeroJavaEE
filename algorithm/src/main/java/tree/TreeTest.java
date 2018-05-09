package tree;

import tree.node.AvlNode;
import tree.node.BinaryNode;
import tree.node.INode.INode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * Tree Test
 * Created by Nero on 2018/3/5.
 */
public class TreeTest {


    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        Random random = new Random();

        for(int i = 0 ; i < 20 ; i++){
            AvlNode avlNode = new AvlNode(random.nextInt(100));
            avlTree.insert(avlNode);
        }

        avlTree.printGraph();
    }




}
