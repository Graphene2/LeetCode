package 树;


import 树.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/10 16:25
 */
public class YES_剑指offer68II二叉树的最近公共组祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if ( right == null) return left;
        if (left == null ) return right;
        return root;
    }
}
