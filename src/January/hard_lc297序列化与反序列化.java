package January;

import 树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-14
 * Time: 21:36
 */
public class hard_lc297序列化与反序列化 {
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            if (cur == null){
                res.append("null,");
            }else {
                res.append(cur.val + ",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        res.setLength(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1,data.length() - 1).split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList<>();
        TreeNode parent = root;
        boolean isLeft = true;
        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = getNode(nodes[i]);
            if (isLeft){
                parent.left = cur;
                isLeft = false;
            }else {
                parent.right = cur;
                isLeft = true;
            }
            if (cur != null){
                parents.add(cur);
            }
            if (isLeft){
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode (String val){
        if (val.equals("null")){
            return null;
        }else {
            return new TreeNode(Integer.valueOf(val));
        }
    }
}
