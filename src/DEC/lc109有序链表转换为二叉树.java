package DEC;

import LinkedList.ListNode;
import 树.TreeNode;

import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-23
 * Time: 10:33
 */
public class lc109有序链表转换为二叉树 {
    public TreeNode sortedListToBST(ListNode head) {
        return builtTree(head,null);
    }

    private TreeNode builtTree(ListNode left, ListNode right) {
            if (left == right){
                return null;
            }
            ListNode mid = getMid(left,right);
            TreeNode root = new TreeNode(mid.val);
            root.left = builtTree(left,mid);
            root.right = builtTree(mid.next,right);
            return root;
    }

    private ListNode getMid(ListNode left, ListNode right) {
        ListNode fast = left,slow = left;
        while (fast != right && fast.next != right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
