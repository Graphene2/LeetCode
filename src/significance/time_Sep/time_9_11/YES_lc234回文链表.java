package significance.time_Sep.time_9_11;

import java.util.Stack;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 11:18
 */
public class YES_lc234回文链表 {
    // 方法一:快慢指针找中间结点，反转链表判断是否回文
    public boolean isPalindrome(ListNode head){
        if (head == null) return true;
        // 首先找到链表中间位置并反转后一个链表。
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        // 根据两个指针比较两个链表是否相同！
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean res = true; // 设置boolean值是为了提前终止循环比较！
        while (res && p2 != null){
            if (p1.val != p2.val) res = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return res;
    }


    // 反转链表操作！
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
    // 查找中间结点，如果长为奇数则为中间结点，如果长度为偶数则为中间偏前的结点！
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // 方法二:栈实现反向访问
    public boolean isPalindrome2(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            s.push(cur);
            cur = cur.next;
        }
        boolean res = true;
        cur = head;
        while (res && cur != null){
            ListNode temp = s.pop();
            if (cur.val != temp.val) res = false;
            cur = cur.next;
        }
        return res;
    }
}
