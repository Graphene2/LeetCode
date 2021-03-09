package 树;

import 树.TreeNode;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,10:56-11:09
 * @version: 1.0
 */
public class YES_lc669修剪二叉搜索树 {
    // 类似于先序遍历，首先访问并确定根节点，然后分别搞定根节点的左右子树。
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val > high) return trimBST(root.left,low,high);
        if (root.val < low) return trimBST(root.right,low,high);
        // 已经找到根节点了，需要修剪根节点的左子树和右子树，最终返回值还是根节点。
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
