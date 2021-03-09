package 树;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,21:50
 * @version: 1.0
 */
public class lc872叶子相似的树 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root1 == null) return true;
        if (root1 == null || root2 == null) return false;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        DFS(root1,list1);
        DFS(root2,list2);
        return list1.equals(list2);
    }

    private void DFS(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(root.val);
        DFS(root.left,list);
        DFS(root.right,list);
    }
}
