package 树;

import 树.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/10 18:55-19:07
 */
public class lc543二叉树的直径 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        DFS(root);
        return res - 1;
    }

    private int DFS(TreeNode root) {
        // 递归终止条件: 结点为null 返回0；
        if (root == null) return 0;
        int left = DFS(root.left);
        int right = DFS(root.right);
        // 获得左右子节点的最大结点数。最后得到的节点数-1即是结果
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
