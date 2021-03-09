package 树;

import 树.TreeNode;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,9:40
 * @version: 1.0
 */
public class lc111二叉树的最小深度 {
    int depth;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // 叶子节点
        if (root.left == null && root.right == null) return 1;
        // 考虑只有一个子节点为空，需要考虑子节点的返回值
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        // 如果有一个子节点为空，则m1和m2中必有一个为0
        if (root.left == null || root.right == null){
            return m1 + m2 + 1;
        }
        // 最后一种情况左右节点都不为空
        return Math.min(m1, m2) + 1;
    }
}
