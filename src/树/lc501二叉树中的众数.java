package 树;

import 树.TreeNode;

import java.util.LinkedList;
import java.util.List;

/** 二叉搜索树:中序遍历！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,22:15
 * @version: 1.0
 */
public class lc501二叉树中的众数 {
    private List<Integer> ans;
    private int cur;
    private int curtimes;
    private int lasttimes;

    public int[] findMode(TreeNode root) {
        ans = new LinkedList<>();
        curtimes = 0;
        inOrder(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (lasttimes == 0) lasttimes = 1;
        if (root.val != cur) curtimes = 0;
        cur = root.val;
        curtimes++;
        if (curtimes == lasttimes){
            ans.add(cur);
        }
        if (curtimes > lasttimes){
            lasttimes = curtimes;
            ans.clear();
            ans.add(cur);
        }
        inOrder(root.right);
    }

}
