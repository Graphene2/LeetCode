package 树;

import 树.time_9_7.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 18:59
 */
public class 剑指offer68_lc235二叉搜索树的最近公共祖先 {
    // 递归
    public 树.time_9_7.TreeNode lowestCommonAncestor(树.time_9_7.TreeNode root, 树.time_9_7.TreeNode p, 树.time_9_7.TreeNode q) {
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
    // 迭代
    public 树.time_9_7.TreeNode lowestCommonAncestor2(树.time_9_7.TreeNode root, 树.time_9_7.TreeNode p, 树.time_9_7.TreeNode q) {
        while (root != null){
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else break;
        }
        return root;
    }
}
