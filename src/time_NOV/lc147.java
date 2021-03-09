package time_NOV;

import LinkedList.ListNode;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-20
 * Time: 9:01
 */
public class lc147 {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null){
            if (lastSorted.val <= curr.val){
                lastSorted = lastSorted.next;
            }else {
                ListNode pre = dummy;
                while (pre.next.val <= curr.val){
                    pre = pre.next;
                }
                lastSorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummy.next;
    }
}
