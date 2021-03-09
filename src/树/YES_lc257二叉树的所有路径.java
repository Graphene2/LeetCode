package 树;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,23:34
 * @version: 1.0
 */
public class YES_lc257二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        DFS(root,"",paths);
        return paths;
    }

    private void DFS(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            // sb先继承path，然后添加该元素并加上->符号！
            StringBuilder sb = new StringBuilder(path);
            sb.append(Integer.toString(root.val));
            if (root.left == null && root.right == null){
                // 到达叶子节点，将完整路径添加到结果中。
                paths.add(sb.toString());
            }else {
                sb.append("->");
                DFS(root.left,sb.toString(),paths);
                DFS(root.right,sb.toString(),paths);
            }

        }
    }
}
