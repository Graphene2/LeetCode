package significance.time_Sep.time_9_11;

/** 跟面试题02.02一样，基础题！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 10:55-11:00
 */
public class 剑指offer22链表中倒数第k个节点 {
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k-- > 0){
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}
