package 树;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/6,22:37
 * @version: 1.0
 */
public class 剑指offer55_lc104二叉树深度 {
    // 深度优先算法，本质是二叉树的后序遍历
    public int maxDepth(TreeNode root) {
        return DFS(root);
    }

    private int DFS(TreeNode root) {
        if (root == null) return 0;
        return Math.max(DFS(root.left), DFS(root.right)) + 1;
    }
    // BFS层次遍历
    public int maxDepth2(TreeNode root){
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>(){{add(root);}},tmp;
        int res = 0;
        while (!queue.isEmpty()){
            // 该操作和每次计算改层队列宽度进行push一样！
            tmp = new LinkedList<>();
            for (TreeNode e:queue){
                if (e.left != null) tmp.add(e.left);
                if (e.right != null) tmp.add(e.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
