package LinkedList;


/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-20
 * Time: 15:04
 */
public class lc876链表的中点 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        return slow;
    }
}
