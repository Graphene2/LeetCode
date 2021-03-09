package March;

import LinkedList.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-11
 * Time: 13:07
 */
public class lc25_K个一组翻转链表 {
    // 迭代方式
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null){
                    return dummy.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] rever = reverseList(head, tail);
            head = rever[0];
            tail = rever[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode p = head;
        ListNode pre = tail.next;
        while (pre != tail){
            ListNode nex = p.next;
            p.next = pre;
            pre = p;
            p = nex;
        }
        return new ListNode[]{tail,head};
    }
    // 递归方式
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null){
                return head;
            }
            tail = tail.next;

        }
        ListNode newHead = MyReverse(head,tail);
        head.next = reverseKGroup2(head.next,k);
        return newHead;
    }

    private ListNode MyReverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
