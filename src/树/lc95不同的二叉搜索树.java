package 树;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-10
 * Time: 9:09
 */
public class lc95不同的二叉搜索树 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1,n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end){
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1,end);
            for(TreeNode left : leftTrees){
                for (TreeNode right : rightTrees){
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
