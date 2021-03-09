package 树;

import 树.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/2 16:55
 */
class YES_lc110平衡二叉树 {
    // 自顶向下的递归
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
    // 自底向上的递归
    public boolean isBalanced2(TreeNode root){
        return height2(root) >= 0;
    }

    public int height2(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}

