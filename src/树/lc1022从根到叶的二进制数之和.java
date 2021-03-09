package 树;

import 树.TreeNode;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/6,22:50
 * @version: 1.0
 */
public class lc1022从根到叶的二进制数之和 {
    int ans = 0;
    int mod = 1000000000 + 7;
    public int sumRootToLeaf(TreeNode root) {
        DFS(root,0);
        return ans % mod;
    }
    public void DFS(TreeNode root, int sum){
        if (root == null) return;
        sum = sum * 2 + root.val;
        if (root.left == null && root.right == null){
            ans += sum;
        }else {
            DFS(root.left,sum);
            DFS(root.right, sum);
        }
    }
}
