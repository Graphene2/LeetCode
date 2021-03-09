package 树;

import 树.time_9_7.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/** 二叉搜索树的合法性
 * 1. 第一遍看答案
 * 2. 第二遍仍然看答案orz，忘记了
 *
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 19:30
 */
public class lc98验证二叉搜索树 {
    // 递归
    public boolean isValidBST(树.time_9_7.TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(树.time_9_7.TreeNode root, 树.time_9_7.TreeNode min, 树.time_9_7.TreeNode max){
        if (root == null) return true;
        if (min != null && min.val >= root.val) return false;
        if (max != null && max.val <= root.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    // 通过中序遍历。迭代方法
    public boolean isValidBST2(树.time_9_7.TreeNode root) {
        Deque<树.time_9_7.TreeNode> stack = new LinkedList<树.time_9_7.TreeNode>();
        int inorder = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
    private class TreeNode{

    }
}
