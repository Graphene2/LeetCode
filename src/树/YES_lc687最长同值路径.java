package 树;


import 树.TreeNode;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/9,21:48
 * @version: 1.0
 */
public class YES_lc687最长同值路径 {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        arrowLength(root);
        return ans;
    }

    private int  arrowLength(TreeNode root) {
        if (root == null) return 0 ;
        int left = arrowLength(root.left);
        int right = arrowLength(root.right);
        int arrowleft = 0, arrowright = 0;
        // 首先分析条件，左边存在并且值相等，
        if (root.left != null && root.left.val == root.val){
            arrowleft += left + 1;
        }
        if (root.right != null && root.right.val == root.val){
            arrowright += right + 1;
        }
        ans = Math.max(ans, arrowleft + arrowright);
        return Math.max(arrowleft,arrowright);
    }
}
