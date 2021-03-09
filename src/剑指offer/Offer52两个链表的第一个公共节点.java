package 剑指offer;

import LinkedList.ListNode;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-18
 * Time: 14:12
 */
public class Offer52两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB){
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
