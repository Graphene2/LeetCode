package LinkedList;


/**
 * Description: 采用双指针
 * User: zhangcheng
 * Date: 2020-10-20
 * Time: 15:17-15:32
 */
public class lc206反转链表 {
    // 自己的答案，ac，下一步进行优化以及逻辑整理
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode p1 = head;
        if (p1.next == null){
            return head;
        }
        ListNode p2 = head.next;
        if (p2.next == null){
            p2.next = p1;
            p1.next = null;
            return p2;
        }
        ListNode p3 = p2.next;
        p1.next = null;
        while (p3 != null){
            p2.next = null;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        return p2;
    }
    // 整理逻辑在这里,还是双指针！这里是迭代的方法进行的。
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    // 采用递归的方法！p 用来保存最后一个节点，然后成为反转后的首节点。
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
