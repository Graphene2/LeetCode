package DP;

import 树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-25
 * Time: 14:12
 */
public class lc337打家劫舍III {
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        int money = root.val;
        if (root.left != null){
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null ){
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money,rob(root.left) + rob(root.right));
    }
    // 可优化记忆节点,通过一个map保存每个节点可以获取的最大偷窃金钱。

    public int rob2(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        return robInternal(root,map);
    }

    private int robInternal(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int money = root.val;
        if (root.left != null){
            money += robInternal(root.left.left,map) + robInternal(root.left.right,map);
        }
        if (root.right != null){
            money += robInternal(root.right.left,map) + robInternal(root.right.right,map);
        }
        int max = Math.max(money,robInternal(root.left,map) + robInternal(root.right,map));
        map.putIfAbsent(root,max);
        return max;
    }
    // 每个节点用一个二维数组表示状态选择，可以选偷还是不偷。
    public int rob3(TreeNode root) {
        int[] res = DFS(root);
        return Math.max(res[0],res[1]);
    }

    private int[] DFS(TreeNode root) {
        if (root == null){
            return new int[]{0,0};
        }
        int[] res = new int[2];
        int[] left = DFS(root.left);
        int[] right = DFS(root.right);
        // 当前节点选择不偷，那么最大值为左右子节点的最大值之和
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        // 当前节点选择偷，那么最大值为当前节点值加上左右子节点选择不偷的最大值之和
        res[1] = root.val + left[0] + right[0];
        return res;
    }


}
