package hot100;

import 树.TreeNode;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-25
 * Time: 8:57-9:13
 */
public class hard_lc124二叉树节点中的最大路径 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 递归计算左右节点的最大共享值。
        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right),0);

        int priceNewPath = root.val + leftGain + rightGain;

        maxSum = Math.max(maxSum,priceNewPath);
        return root.val + Math.max(leftGain,rightGain);
    }

}
