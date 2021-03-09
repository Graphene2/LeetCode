package 树;

import 树.TreeNode;

/** 典型的中序遍历的题目！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/10 19:54
 */
public class lc783二叉搜索树节点最小距离 {
    Integer res, pre;
    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = null;
        if (root == null) return 0;
        DFS(root);
        return res;
    }

    private void DFS(TreeNode root) {
        if (root == null) return;
        DFS(root.left);
        if (pre != null)
        res = Math.min(res,root.val - pre);
        pre = root.val;
        DFS(root.right);
    }
}
