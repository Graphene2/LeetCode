package 树;

import java.util.*;

/**本质上还是先序遍历，不过每次遍历都要将该层次用括号括起来。 看到题目的时候先分析题意，仔细列出所有的情况。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/4 9:36-10:43
 */
public class YES_lc606根据二叉树创建字符串 {
    public String tree2str2(TreeNode t) {
        // 迭代
        if (t == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(t);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            t = stack.peek();
            if (visited.contains(t)){
                stack.pop();
                sb.append(")");
            }else {
                visited.add(t);
                sb.append("("+t.val);
                if (t.left == null && t.right != null) sb.append("()");
                if (t.right != null) stack.push(t.right);
                if (t.left != null) stack.push(t.left);
            }
        }
        return sb.substring(1, sb.length() - 1);
    }
    // 递归
    public String tree2str(TreeNode t){
        if (t == null) return "";
        if (t.left == null && t.right == null) return t.val+"";
        if (t.right == null)  return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str2(t.right) + ")";
    }


    // 递归，前序遍历，主要是分析各种终止情况，然后把相似部分整合一起就可以了！
    public String tree2str3(TreeNode t) {
        if (t == null) return "";
        // 递归终止条件：如果为叶子结点，返回最终值。
        if (t.left == null && t.right == null) return t.val + "";
        if (t.right == null) return t.val + "(" + tree2str3(t.left) + ")";

        return t.val + "(" + tree2str3(t.left) + ")(" + tree2str3(t.right) + ")";

    }
}
