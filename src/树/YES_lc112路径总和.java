package 树;

import java.util.*;

/**  当题目中提到了叶子节点时，正确的做法一定要同时判断节点的左右子树同时为空才是叶子节点。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/4 10:44
 */
class YES_lc112路径总和 {
    // 方法一:广度优先搜索：分别用两个队列进行存储节点和数值！
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()){
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            // now为叶子结点，计算最终判断条件并继续下一个队列元素！
            if (now.left == null && now.right == null){
                if (temp == sum){
                    return true;
                }
                continue;
            }
            // now节点有子节点，将该子节点和子节点的加和存入队列中！
            if (now.left != null){
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null){
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
    // 深度优先搜索 即递归！
    public boolean hasPathSum(TreeNode root, int sum){
        if (root == null) return false;
        if (root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }




    public boolean hasPathSum3(TreeNode root, int sum){
        // 递归结束条件有三个：1.节点为空
        if (root == null) return false;
        // 2.节点为叶子结点，判断是否与剩下的数相等
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        // 3.该节点还有子节点，继续递归条件到下一步！ 即寻找递归等价关系式！
        return hasPathSum3(root.left,sum - root.left.val) || hasPathSum(root.right, sum - root.right.val);

    }

}
