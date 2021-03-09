package 树;

import 树.time_9_7.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 21:49
 */
public class lc965单值二叉树 {
    // 深度优先搜索
    boolean ans = true;
    public boolean isUnivalTree2(树.time_9_7.TreeNode root) {
        if (root == null) return true;
        int m = root.val;
        DFS(root.left, m);
        return ans;
    }

    private void DFS(树.time_9_7.TreeNode root, int m) {
        if (root == null) return;
        if (m != root.val) ans = false;
        DFS(root.left, m);
        DFS(root.right, m);
    }

    // 递归方法,递归方法需要保证当前返回值为false时能够一直向上传递！
    public boolean isUnivalTree(树.time_9_7.TreeNode root){
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree2(root.right)));
        return left_correct && right_correct;
    }
}
