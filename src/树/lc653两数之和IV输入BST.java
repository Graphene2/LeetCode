package 树;

import 树.TreeNode;

import java.util.HashSet;
import java.util.Set;

/** 直接中序遍历即为有序排序，用set或者map
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,11:50
 * @version: 1.0
 */
public class lc653两数之和IV输入BST {
    Set<Integer> seen = new HashSet<>();
    boolean flag = false;
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        findTarget(root.left,k);
        if (seen.contains(k - root.val)) flag = true;
        seen.add(root.val);
        findTarget(root.right,k);
        return flag;
    }
}
