package 树;

import 树.TreeNode;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,12:29
 * @version: 1.0
 */
public class YES_lc993堂兄弟节点 {
    TreeNode[] nodes = new TreeNode[2];
    int[] depths = new int[2];
    int i = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
            helper(root,x,0,null);
            helper(root,y,0,null);
            return depths[0] == depths[1] && nodes[0].val != nodes[1].val;
    }

    private void helper(TreeNode root, int x, int depth, TreeNode pre) {
        if (root == null) return;
        if (root.val != x) {
            helper(root.left,x,depth + 1,root);
            helper(root.right,x,depth + 1,root);
        }else {
            nodes[i] = pre;
            depths[i] = depth;
            i++;
            return;
        }
    }
}
