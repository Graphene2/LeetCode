package 树;

import 树.TreeNode;

/** 简单的前序遍历！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 21:23
 */
public class lc226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null ) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}
