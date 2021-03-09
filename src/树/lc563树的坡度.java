package 树;

import 树.TreeNode;



/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,23:11-23:32
 * @version: 1.0
 */
public class lc563树的坡度 {
    int sum = 0;
    public int findTilt(TreeNode root) {
        DFS(root);
        return sum;

    }
    public int DFS(TreeNode root) {
        if(root==null ) return 0;
        int left = DFS(root.left);
        int right = DFS(root.right);
        sum += Math.abs(left-right);
        return left+right+root.val;
    }
}
