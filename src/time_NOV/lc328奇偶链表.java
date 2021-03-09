package time_NOV;

import LinkedList.ListNode;

/** 解题速度太慢了。
 * Description:
 * User: zhangcheng
 * Date: 2020-11-13
 * Time: 9:01-9:30
 */
public class lc328奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd =  new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode p3 = odd, p4 = even;
        if (head == null || head.next == null) return head;
        ListNode p1 = head, p2 = head.next;
        while (p2 != null && p2.next != null){
            even.next = p1;
            even = even.next;
            odd.next = p2;
            odd = odd.next;
            p1 = p1.next.next;
            p2 = p2.next.next;
        }
        even.next = p1;
        even = even.next;
        odd.next = p2;
//        even.next = null;
        even.next = p3.next;
        return p4.next;
    }
    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
