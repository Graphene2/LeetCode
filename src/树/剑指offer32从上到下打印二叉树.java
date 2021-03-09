package 树;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**同主站lc102
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/2,21:49
 * @version: 1.0
 */
public class 剑指offer32从上到下打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(tmp);
        }
        return ans;
    }
}
