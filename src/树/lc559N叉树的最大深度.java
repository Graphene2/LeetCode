package 树;

import java.util.List;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/10 19:39-19:55
 */
public class lc559N叉树的最大深度 {
    public int maxDepth(Node root) {
        return DFS(root);
    }
    // 递归目的：DFS返回值为当前root的最大深度。
    private int DFS(Node root) {
        if (root == null) return 0;
        int max = 0;
        if (root.children == null) return 1;
        for (Node now: root.children){
            max = Math.max(max,DFS(now));
        }
        return max + 1;
    }
}

