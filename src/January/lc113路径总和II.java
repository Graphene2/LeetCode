package January;

import 树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-02
 * Time: 14:12
 */
public class lc113路径总和II {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null){
            return;
        }
        path.offer(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0){
            res.add(new LinkedList<>(path));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        path.pollLast();
    }


}
