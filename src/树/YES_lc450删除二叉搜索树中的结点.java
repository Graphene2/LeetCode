package 树;

import 树.time_9_7.TreeNode;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/7 20:03
 */
public class YES_lc450删除二叉搜索树中的结点 {
    // 递归！
    public 树.time_9_7.TreeNode deleteNode(树.time_9_7.TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key){
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            if (root.right != null && root.right != null){
                树.time_9_7.TreeNode minNode = getMin(root.right);
                root = minNode;
                root.right = deleteNode(root.right, minNode.val);
            }

        }else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private 树.time_9_7.TreeNode getMin(树.time_9_7.TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

}
