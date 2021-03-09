package 树;

/**最优方法是后续遍历+剪枝。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/4 11:20
 */
public class 剑指offer55_面试55平衡二叉树 {
    // 采用后序遍历+剪枝方式进行剪枝。
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }

    // 采用
}
