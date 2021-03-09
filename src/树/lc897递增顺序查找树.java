package 树;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 很关键一点，在通过链表重新排列成树的时候，创建的第一个节点为索引，应该从cur.right开始计算！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/3 9:45
 */
public class lc897递增顺序查找树 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root,vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v:vals){
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }
    public void  inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

    // 迭代法中序遍历
    public TreeNode increasingBST2(TreeNode root){
        List<Integer> vals = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                vals.add(root.val);
                root = root.right;
            }
        }
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v:vals){
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }
}
