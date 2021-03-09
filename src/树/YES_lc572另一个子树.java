package 树;

import 树.TreeNode;


/**给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/10,23:50
 * @version: 1.0
 */
public class YES_lc572另一个子树 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false; // 只要s == null 表示递归到s的叶子节点，递归终止，返回false；
        return isSame(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    // 判断两棵树是否相同！
    private boolean isSame(TreeNode temp, TreeNode t) {
        if (temp == null && t == null) return true;
        if (temp == null || t == null ) return false;
        if (temp.val != t.val) return false;
        return isSame(temp.left,t.left) && isSame(temp.right,t.right);
    }
}
