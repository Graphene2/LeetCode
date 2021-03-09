package time_Oct;

import 树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-29
 * Time: 9:29
 */
public class lc129求根到叶子节点数字之和 {
    public int sumNumbers(TreeNode root) {
        return preOrder(root, 0);
    }

    private int preOrder(TreeNode root, int preSum) {
        if (root == null){
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }else {
            return preOrder(root.left,sum) + preOrder(root.right,sum);
        }
    }
    // BFS 层次遍历

    public int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left,right = node.right;
            if (left == null && right == null){
                sum += num;
            }else {
                if (left != null){
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null){
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + left.val);
                }
            }
        }
        return sum;
    }
}
