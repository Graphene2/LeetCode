package LinkedList;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-07
 * Time: 20:57
 */
public class lc92反转链表II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n){
            return head;
        }
        int count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        // first反转的前一个位置。
        for (int i = 0; i < m - 1; i++) {
            first = first.next;
        }
        // second 为反转链表最后一个位置
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            second = second.next;
        }
        ListNode third = second.next;
        ListNode reverHead = first.next;
        first.next = null;
        ListNode tail = reverHead;
        second.next = null;
        ListNode secondHead = reverse(reverHead);
        first.next = secondHead;
        tail.next = third;
        return dummy.next;
    }

    private ListNode reverse(ListNode second) {
        if (second == null){
            return null;
        }
        ListNode cur = second, pre = cur.next;
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
