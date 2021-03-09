package significance.time_Sep;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-23
 * Time: 15:43
 */
public class lc21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode ans = head;
        ListNode first = l1, sec = l2;
        while (first != null && sec != null){
            if (first.val <= sec.val){
                head.next = first;
                first = first.next;
            }else {
                head.next = sec;
                sec = sec.next;
            }
            head = head.next;
        }
        if (first == null){
            head.next = sec;
        }else {
            head.next = first;
        }
        return ans.next;
    }
}

