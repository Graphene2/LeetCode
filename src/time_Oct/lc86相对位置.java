package time_Oct;

import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-30
 * Time: 16:26
 */
public class lc86相对位置 {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1);
        ListNode dummp = res;
        for (ListNode ptr = head; ptr != null; ptr = ptr.next){
            if (ptr.val < x){
                ListNode temp = new ListNode(ptr.val);
                res.next = temp;
                res = res.next;
            }
        }
        for (ListNode ptr = head; ptr != null; ptr = ptr.next){
            if (ptr.val >= x){
                ListNode temp = new ListNode(ptr.val);
                res.next = temp;
                res = res.next;
            }
        }
        return dummp.next;
    }
    // 不要创建新节点， 并且 val 只读。意味着需要把当前节点拆分，也就是需要进行,说实话没看懂
    public ListNode partition2(ListNode head, int x) {
        ListNode curNode = head;
        ListNode preNode = null;
        ListNode lastMinNode = null;
        while (curNode != null){
            if ((curNode.val < x) && (preNode != null) && (preNode != lastMinNode)){
                preNode.next = preNode.next.next;
                if (lastMinNode != null) {
                    // 插入到已扫描的最后一个小于分割节点的后面
                    curNode.next = lastMinNode.next;
                    lastMinNode.next = curNode;
                } else {
                    // 交换到头节点
                    ListNode tempNode = head;
                    head = curNode;
                    head.next = tempNode;
                }
                // 已扫描的最后一个不大于 x 的节点
                lastMinNode = curNode;
            } else if (curNode.val < x) {
                // 已扫描的最后一个不大于 x 的节点
                lastMinNode = curNode;
            }
            // 保留当前节点
            preNode = curNode;
            // 节点下移
            curNode = curNode.next;
        }
        return head;
    }
    // 官方推荐双指针的解法,简单易懂，而且不需要创建新的节点
    public ListNode partition3(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }

}
