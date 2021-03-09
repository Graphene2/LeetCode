package 树;

import 树.time_9_7.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 19:57
 */
public class lc701二叉搜索树的插入操作 {
    public 树.time_9_7.TreeNode insertIntoBST(树.time_9_7.TreeNode root, int val) {
        if (root == null) return new 树.time_9_7.TreeNode(val);
        if (root.val < val) return insertIntoBST(root.right, val);
        if (root.val > val) return insertIntoBST(root.left, val);
        return root;
    }
}
