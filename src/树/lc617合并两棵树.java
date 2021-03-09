package 树;


import java.util.Stack;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 17:21
 */
public class lc617合并两棵树 {
    public 树.time_9_7.TreeNode mergeTrees(树.time_9_7.TreeNode t1, 树.time_9_7.TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
    // 迭代
    public 树.time_9_7.TreeNode mergeTrees2(树.time_9_7.TreeNode t1, 树.time_9_7.TreeNode t2){
        if (t1 == null) return t2;
        Stack<树.time_9_7.TreeNode[] > stack = new Stack<>();
        stack.push(new 树.time_9_7.TreeNode[]{t1, t2});
        while (!stack.isEmpty()){
            树.time_9_7.TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null){
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null){
                t[0].left = t[1].left;
            }else {
                stack.push(new 树.time_9_7.TreeNode[]{t[0].left, t[1].left});
            }
            if (t[0].right == null){
                t[0].right = t[1].right;
            }else {
                stack.push(new 树.time_9_7.TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }
    private class TreeNode {
        int val;
        树.time_9_7.TreeNode left;
        树.time_9_7.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, 树.time_9_7.TreeNode left, 树.time_9_7.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
