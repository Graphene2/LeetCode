package 树;

import 树.time_9_7.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 19:58
 */
public class lc700二叉搜索树中的搜索 {
    public 树.time_9_7.TreeNode searchBST(树.time_9_7.TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val < val) return searchBST(root.right, val);
        if (root.val > val) return searchBST(root.left, val);
        return null;
    }
}
