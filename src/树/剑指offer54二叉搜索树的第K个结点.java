package 树;


import java.util.Stack;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/4 8:50
 */
public class 剑指offer54二叉搜索树的第K个结点 {
    // 此为迭代方法。
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.right;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                count++;
                if (count == k){
                    return root.val;
                }
                root = root.left;
            }
        }
        return -1;
    }

    // 递归方法：
    int result = -1;
    int count;
    public int kthLargest2(TreeNode root, int k){
        count = k;
        DFS(root);
        return result;
    }

    private void DFS(TreeNode root) {
        if (root == null) return;
        DFS(root.right);
        if (count == 1){
            result = root.val;
            count--;
            return;
        }
        count--;
        DFS(root.left);
    }

}

