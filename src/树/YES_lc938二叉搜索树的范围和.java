package 树;


import 树.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/8 9:22
 */
public class YES_lc938二叉搜索树的范围和 {
    // 深度优先搜索  可以直接中序遍历
    int sum;
    public int rangeSumBST2(TreeNode root, int L, int R) {
        sum = 0;
        DFS(root, L, R);
        return sum;

    }

    private void DFS(TreeNode root, int L, int R) {
        if (root == null) return ;
        if (root.val >= L && root.val <= R)  sum += root.val;
        if (root.val > L) DFS(root.right, L, R);
        if (root.val < R)  DFS(root.left, L ,R);
    }

    // 直接中序遍历
    int ans;
    public int rangeSumBST4(TreeNode root, int L, int R){
        ans = 0;
        DFS_mid(root,L,R);
        return ans;
    }
    private void DFS_mid(TreeNode root, int L, int R) {
        if (root == null) return;
        DFS_mid(root.left,L,R);
        if (L <= root.val && root.val <= R){
            ans += root.val;
        }
        DFS_mid(root.right, L ,R);
    }

    // 有选择性遍历
    int res = 0;
    public int rangeSumBST3(TreeNode root, int L , int R){
        traversal(root, L, R);
        return res;
    }

    private void traversal(TreeNode root, int L, int R) {
        if (root == null) return;
        if (root.val >= L && root.val <= R) {
            res += root.val;
            traversal(root.left,L,R);
            traversal(root.right,L,R);
        }
        if (root.val < L) traversal(root.right,L,R);
        if (root.val > R) traversal(root.left,L,R);
    }

    // 比较标准的递归！
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }


}
