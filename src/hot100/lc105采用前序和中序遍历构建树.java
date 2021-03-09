package hot100;

import 树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-23
 * Time: 9:43-10:13
 */
public class lc105采用前序和中序遍历构建树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen){
            throw new RuntimeException("Error input Data!");
        }
        return buildTree(preorder,0,preLen - 1,inorder,0,inLen - 1);
    }

    /**
     *使用数组 preorder 在索引区间 [preLeft, preRight] 中的所有元素
     *和数组 inorder 在索引区间 [inLeft, inRight] 中的所有元素构造二叉树
     * @param preorder 二叉树前序遍历结果
     * @param preLeft  二叉树前序遍历结果的左边界
     * @param preRight 二叉树前序遍历结果的右边界
     * @param inorder  二叉树中序遍历结果
     * @param inLeft   二叉树中序遍历结果的左边界
     * @param inRight  二叉树中序遍历结果的右边界
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight){
            return null;
        }
        // 前序遍历起点为根节点
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = inLeft;
        while (inorder[pivotIndex] != pivot){
            pivotIndex++;
        }
        root.left = buildTree(preorder,preLeft + 1,preLeft + pivotIndex - inLeft,
                inorder,inLeft,pivotIndex - 1);
        root.right = buildTree(preorder,preLeft + pivotIndex - inLeft + 1,preRight,
                inorder,pivotIndex + 1,inRight);
        return root;
    }
    // 采用HashMap的方法存储
    private int[] preorder;
    private Map<Integer, Integer> hash;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen){
            throw new RuntimeException("Error input Data!");
        }
        this.hash = new HashMap<>();
        this.preorder = preorder;
        for (int i = 0; i < inLen; i++) {
            hash.put(inorder[i],i);
        }
        return buildTree(0,preLen - 1,0,inLen - 1);
    }

    private TreeNode buildTree(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight){
            return null;
        }
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = hash.get(pivot);
        root.left = buildTree(preLeft + 1,pivotIndex - inLeft + preLeft, inLeft,pivotIndex - 1);
        root.right = buildTree(pivotIndex - inLeft + preLeft + 1,preRight,pivotIndex + 1,inRight);
        return root;
    }
}
