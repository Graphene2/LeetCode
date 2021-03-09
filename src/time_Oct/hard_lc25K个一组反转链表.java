package time_Oct;


import org.w3c.dom.ls.LSInput;

import java.awt.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-27
 * Time: 14:15
 */
public class hard_lc25K个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy  = new ListNode(0);
        dummy .next = head;
        ListNode pre = dummy ;
        ListNode end = dummy ;

        while (end.next != null){
            for (int i = 0; i < k && end != null;i++){ end = end.next;}
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseList(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
