package significance.time_Sep.time_9_11;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 10:15
 */
class lc141环形链表 {
    // 方法一:哈希表
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSeen = new HashSet<>();
        while (head != null){
            if (nodeSeen.contains(head)){
                return true;
            }else {
                nodeSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
    // 方法二:双指针！
    public boolean hasCycle2(ListNode head){
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
