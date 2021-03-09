package 树;

import 树.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 8:50-8:54
 */
public class 面试17_12BiNode {
    TreeNode head = new TreeNode(-1);
    TreeNode pre = null;
    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre == null) {
            pre = root;
            head.right = root;
        }else {
            pre.right = root;
            pre = root;
        }
        root.left = null; // 将右指针设置为空
        helper(root.right);
    }
}
