package 树;

import 树.TreeNode;

import java.util.Stack;

/** 降序累加，即中序的翻过来
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/10 20:27-20:45
 */
public class lc538把二叉搜索树转换为累加树 {
    int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        DFS(root);
        return root;
    }

    private void DFS(TreeNode root) {
        if (root == null) return;
        DFS(root.right);
        root.val += pre;
        pre = root.val;
        DFS(root.left);
    }
    // 使用栈完成反中序
    public TreeNode convertBST2(TreeNode root){
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || node != null){
            while (node != null){
                s.push(node);
                node = node.right;
            }
            if (!s.isEmpty()){
                node = s.pop();
                node.val += sum;
                sum = node.val;
                node = node.left;
            }
        }
        return root;
    }
}
