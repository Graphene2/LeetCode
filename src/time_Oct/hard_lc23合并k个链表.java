package time_Oct;

import jdk.jfr.StackTrace;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-23
 * Time: 9:07
 */
public class hard_lc23合并k个链表 {
    // 使用分治方法进行两两合并
    public ListNode mergeKLists(ListNode[] lists){
        return merge(lists,0,lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right){
            return lists[left];
        }
        if (left > right){
            return null;
        }
        int mid = (left + right) / 2;
        return mergeTwoLists(merge(lists,left,mid),merge(lists,mid + 1,right));
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null){
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head,aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null){
            if (aPtr.val < bPtr.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr == null ? bPtr : aPtr);
        return head.next;
    }
    // 使用优先队列合并
    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }
        //
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }
    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists2(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()){
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null){
                queue.offer(new Status(f.ptr.next.val,f.ptr.next));
            }
        }
        return head.next;
    }
}
