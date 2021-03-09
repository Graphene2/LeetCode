package 树;

import 树.TreeNode;

import java.util.Map;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/10 20:46
 */
public class 面试0404检查平衡性 {
    // 从顶向下的递归！
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced2(root.left) && isBalanced2(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }
    // 自底向上的递归！
    public boolean isBalanced(TreeNode root) {
        return height2(root) > 0;
    }

    private int height2(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
