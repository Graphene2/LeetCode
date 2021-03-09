package January;

import 树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-14
 * Time: 16:29
 */
public class lc437路径总和III {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1);
        return rePathSum(root,prefixSumCount,sum,0);
    }

    private int rePathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        if (node == null){
            return 0;
        }
        int res = 0;
        currSum += node.val;
        res += prefixSumCount.getOrDefault(currSum - target,0);
        prefixSumCount.put(currSum,prefixSumCount.getOrDefault(currSum,0) + 1);

        res += rePathSum(node.left,prefixSumCount,target,currSum);
        res += rePathSum(node.right,prefixSumCount,target,currSum);
        prefixSumCount.put(currSum,prefixSumCount.get(currSum) - 1);
        return res;
    }
}
