package 剑指offer;

import LinkedList.ListNode;

/**
 * Description: 该题同lc206，经典链表问题1
 * User: zhangcheng
 * Date: 2020-12-07
 * Time: 20:36
 */
public class Offer24反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode cur = head, pre = cur.next;
        ListNode suc = null;
        while (pre != null){
            cur.next = suc;
            suc = cur;
            cur = pre;
            pre = pre.next;
        }
        cur.next = suc;
        return cur;
    }
}
