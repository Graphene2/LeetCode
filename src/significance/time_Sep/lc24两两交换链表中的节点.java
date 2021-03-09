package significance.time_Sep;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-23
 * Time: 18:36
 */
public class lc24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode first = dummyNode, second = dummyNode.next;
        while (second != null){
            ListNode temp = first;
            first = first.next;
            if (first == null) break;
            second = first.next;
            first.next = second.next;
            second.next = first;
            temp.next = second;
        }
        return dummyNode.next;
    }

    public ListNode swapPairs2(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }
        return dummy.next;
    }
}
