package hot100;

import LinkedList.ListNode;
import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-24
 * Time: 9:23
 */
public class lc114二叉树展开为链表 {
    public void flatten(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        DFS(root,res);
        int size = res.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = res.get(i - 1), curr = res.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void DFS(TreeNode root, List<TreeNode> res) {
        if (root != null){
            res.add(root);
            DFS(root.left,res);
            DFS(root.right,res);
        }
    }
    // 第二种方法。可以画图理解
    public void flatten2(TreeNode root) {
        while (root != null){
            // 左子树为null,直接考虑下一个节点
            if (root.left == null){
                root = root.right;
            }else {
                TreeNode prev = root.left;
                while (prev.right != null){
                    prev = prev.right;
                }
                // 将原来的右子树嫁接到左子树的最右子叶上。
                prev.right = root.right;
                // 将左子树插到右子树的地方。
                root.right = root.left;
                root.left = null;
            }
        }
    }



}
