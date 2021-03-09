package 树;

import 树.time_9_7.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 还是BFS，不过存放的时候每次从最前面开始存放！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 18:00
 */
public class YES_lc107二叉树的层次遍历 {
    public List<List<Integer>> levelOrderBottom(树.time_9_7.TreeNode root) {
        Queue<树.time_9_7.TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new LinkedList<>();
            for (int i = queue.size() - 1; i >= 0; i--){
                树.time_9_7.TreeNode now = queue.poll();
                temp.add(now.val);
            if (now.left != null) queue.add(now.left);
            if (now.right != null) queue.add(now.right);
            }
            ans.add(0,temp);
        }
        return ans ;
    }
}
