package 树;


import 树.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/8 8:50
 */
public class YES_面试题04_02最小高度数 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return DFS(nums, 0, nums.length - 1);
    }
    private TreeNode DFS(int[] nums, int low, int high) {
        if (low > high){
            return null;
        }
        int mid = (high + low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = DFS(nums, low, mid - 1);
        root.right = DFS(nums, mid + 1, high);
        return root;
    }
}
