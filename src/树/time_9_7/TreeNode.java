package 树.time_9_7;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-23
 * Time: 15:34
 */
 public class TreeNode {
    public int val;
    public TreeNode left;
    public  TreeNode right;
    public  TreeNode() {}
    public  TreeNode(int val) { this.val = val; }
    public  TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
