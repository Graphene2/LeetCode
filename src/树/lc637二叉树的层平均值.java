package 树;


import 树.TreeNode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 很典型的BFS题目。可以用queue完成！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/10 19:23
 */
public class lc637二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = size - 1; i >= 0; i--){
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                sum += cur.val;
            }
            ans.add((double)sum / size);
        }
        return ans;
    }
}
