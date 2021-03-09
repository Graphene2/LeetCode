package time_NOV;

import 树.TreeNode;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-24
 * Time: 9:04
 */

public class lc222完全二叉树的节点个数 {
    // 暴力方法直接统计节点的个数
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
    //
    public int countNodes2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right){
            return countNodes2(root.right) + (1 << left);
        }else {
            return countNodes2(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null){
            level++;
            root = root.left;
        }
        return level;
    }


}
