package DEC;

import 树.TreeNode;

import java.util.HashMap;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-23
 * Time: 9:56
 */
public class lc106从中序与后序遍历序列构造二叉树 {
    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i],i);
        }
        post = postorder;
        TreeNode root = buildTree(0,inorder.length - 1,0,postorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int inorderLeft, int inorderRight, int postLeft, int postRight) {
        if (inorderLeft > inorderRight || postLeft > postRight){
            return null;
        }
        int rootVal = post[postRight];
        int rootIdx = memo.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = buildTree(rootIdx + 1, inorderRight, postLeft + rootIdx - inorderLeft,postRight - 1);
        root.left = buildTree(inorderLeft,rootIdx - 1,postLeft,postLeft + rootIdx - 1 - inorderLeft);
        return root;
    }
}
