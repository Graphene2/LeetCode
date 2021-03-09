package 树;

import 树.TreeNode;


/** 二分法
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/11,0:29
 * @version: 1.0
 */
public class lc108将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums,0,nums.length - 1);
    }

    private TreeNode BST(int[] nums, int L, int R) {
        if (L > R) return null;
        int mid = (L + R) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums,L,mid - 1);
        root.right = BST(nums,mid + 1,R);
        return root;
    }


}
