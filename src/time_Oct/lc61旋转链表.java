package time_Oct;



/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-14
 * Time: 16:10
 */
public class lc61旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        int len;
        ListNode ptr = head;
        for (len = 1;ptr.next != null;len++){
            ptr = ptr.next;
        }
        ptr.next = head;

        int m = len - k % len;
        ptr = head;
        int pos = 1;
        while (pos < m){
            ptr = ptr.next;
            pos++;
        }
        head = ptr.next;
        ptr.next = null;
        return head;
    }
}
