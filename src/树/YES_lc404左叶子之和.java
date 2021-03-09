package 树;

import 树.time_9_7.TreeNode;

/** 制作一个标志位进行左叶子的判断！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 21:09
 */
public class YES_lc404左叶子之和 {
    int ans = 0;
    boolean flag = false;
    public int sumOfLeftLeaves(树.time_9_7.TreeNode root) {
        if (root == null) return 0;
        DFS(root,false);
        return ans;
    }

    private void DFS(树.time_9_7.TreeNode root, boolean flag) {
        if (root == null) return;
        if (root.left == null && root.right == null && flag == true ){
            ans += root.val;
        }
        DFS(root.left, true);
        DFS(root.right, false);
    }
}
