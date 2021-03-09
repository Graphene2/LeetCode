package 树;



/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/6,22:59
 * @version: 1.0
 */
public class YES_剑指offer28_lc101对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : DFS(root.left, root.right);
    }

    private boolean DFS(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return DFS(left.left, right.right) && DFS(left.right, right.left);
    }
}
