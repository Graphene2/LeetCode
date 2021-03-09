package 树;

import 树.TreeNode;



/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,10:29
 * @version: 1.0
 */
public class YES_lc671二叉树中第二小的节点 {
    //
    int res = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return res;
        //如果存在子树并且值不相等，那么较大的值就有可能是第二小的
        if (root.left != null && root.left.val != root.right.val){
            //获取左右子树中将较大的值
            int bigger = Math.max(root.left.val,root.right.val);
            //如果返回值没有被更改过，则bigger有可能就是第二小的，如果返回值被更改过，则比较当前的res和bigger哪个更小
            res = res == -1 ? bigger : Math.min(res ,bigger);
            //将左右子树中值更小的树进行递归，查找是否有更小的值（即为了上一步判断）
            findSecondMinimumValue(root.left.val > root.right.val ? root.right : root.left);
        }
        //如果左右子树相等或为空，分别递归
        else {
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }
        return res;
    }

    public int findSecondMinimumValue2(TreeNode root)
    {
        int rootValue = root.val;
        return DFS(root, rootValue);

    }
    private int DFS(TreeNode x, int rootValue) {
        if (x.val != rootValue)  return x.val;
        if (x.left == null) return -1;
        int leftMin = DFS(x.left,rootValue);
        int rigthMin = DFS(x.right,rootValue);
        if (leftMin == -1) return rigthMin;
        if (rigthMin == -1) return leftMin;

        return Math.min(leftMin,rigthMin);
    }

}
