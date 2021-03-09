package 树;

import 树.time_9_7.TreeNode;

/** BST的中序遍历是递增的！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 20:52
 */
public class lc530二叉搜索树的最小绝对差 {
    树.time_9_7.TreeNode pre;
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(树.time_9_7.TreeNode root) {
        if (root == null) return 0;
        DFS(root);
        return ans;
    }

    private void DFS(树.time_9_7.TreeNode root) {
        if (root == null) return;
        DFS(root.left);
        if (pre != null){
            ans = Math.min(ans, root.val - pre.val);
        }
        pre = root;
        DFS(root.right);
    }
}
