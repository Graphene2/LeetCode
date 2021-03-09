package hot100;


import LinkedList.ListNode;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-06
 * Time: 16:50
 */
public class lc127环形链表2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while ( fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
