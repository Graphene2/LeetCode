package JAVAFORMEETING;

import 树.time_9_7.TreeNode;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-04-13
 * Time: 10:21
 */
public class lc783二叉搜索树节点最小距离 {
    int pre;
    int ans;

    public int minDiffInBST(TreeNode root){
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
