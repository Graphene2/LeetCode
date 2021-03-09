package 树;


/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 19:10
 */
public class lc100相同的数 {
    // 递归
    public boolean isSameTree(树.time_9_7.TreeNode p, 树.time_9_7.TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

