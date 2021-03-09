package 树;

import 树.TreeNode;


/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,22:06
 * @version: 1.0
 */
public class YES_lc236二叉树的最近公共祖先 {
    // 递归目的，找出最近公共祖先
    // 递归终止条件:节点为空 /节点为p /或者节点为q /p和q的最小公共祖先。
    // 缩小规模方式:不断延伸到子树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
