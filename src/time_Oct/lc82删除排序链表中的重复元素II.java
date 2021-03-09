package time_Oct;

import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-28
 * Time: 22:00
 */
public class lc82删除排序链表中的重复元素II {
    // 双指针的方法
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummp = new ListNode(-1);
        dummp.next = head;
        ListNode pre = dummp;
        ListNode curr = head;
        while (curr != null && curr.next != null){
            if (pre.next.val != curr.next.val){
                pre = pre.next;
                curr = curr.next;
            }else {
                while (curr != null && curr.next != null && pre.next.val == curr.next.val){
                    curr = curr.next;
                }
                curr = curr.next;
                pre.next = curr;
            }
        }
        return dummp.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 出现重复元素那就删除，将重复节点最后一个节点的下一个节点返回。
        if (head.val == head.next.val){
            while (head != null && head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates2(head.next);
        }else {
            // 没有出现重复节点，返回当前节点，同时下一个节点连接上。
            head.next = deleteDuplicates2(head.next);
            return head;
        }
    }
}
