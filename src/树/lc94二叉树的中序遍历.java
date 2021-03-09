package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/2,22:05
 * @version: 1.0
 */
public class lc94二叉树的中序遍历 {
    // 使用递归方式进行中序遍历
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        if (root == null) return ans;
        DFS(root);
        return ans;
    }

    private void DFS(TreeNode root) {
        if (root == null) return;
        DFS(root.left);
        ans.add(root.val);
        DFS(root.right);
    }
    // 使用迭代方式进行中序遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
