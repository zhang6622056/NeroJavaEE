package tree;

/**
 * 遍历获取无规则二叉树，最大节点
 * Created by admin on 2018-07-12.
 */
public class MaxBinaryTree {

    public TreeNode MaxNode(TreeNode root){
        if(null == root){
            return null;
        }
        TreeNode l = MaxNode(root.left);
        TreeNode r = MaxNode(root.right);
        return max(root,max(l,r));
    }


    /***
     * 获取左右节点最大节点
     * @return
     */
    public TreeNode max(TreeNode l,TreeNode r){
        if(l == null){
            return r;
        }
        if(r == null){
            return l;
        }

        if(l.val > r.val){
            return l;
        }else{
            return r;
        }
    }

    class TreeNode {
             public int val;
             public TreeNode left, right;
             public TreeNode(int val) {
                     this.val = val;
                     this.left = this.right = null;
             }
    }


}


