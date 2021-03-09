package LinkedList;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 16:48
 */
public class lc83删除排序链表中重复项___双指针 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null){
            if (fast.val != slow.val){
                slow = slow.next;
                slow.val = fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}


