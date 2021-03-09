package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-20
 * Time: 10:44
 */
public class lc143链表重排 {
    // 第一版，通过采用线性数组存储做出来了。现在开始改进
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode ptr = head;
        list.add(ptr);
        while (ptr.next != null){
            ptr = ptr.next;
            list.add(ptr);
        }
        if (list.size() == 2){
            return;
        }
        head.next = null;
        int left = 1, right = list.size() - 1;
        ListNode p1 = head;
        while (left < right){
            p1.next = list.get(right);
            right--;
            p1 = p1.next;
            p1.next = null;
            p1.next = list.get(left);
            left++;
            p1 = p1.next;
            p1.next = null;
            if (left == right){
                p1.next = list.get(left);
                p1 = p1.next;
                p1.next = null;
            }
        }
    }
    // 第二版:官方采用线性数组的题解
    public void reorderList2(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null){
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j){
            list.get(i).next = list.get(j);
            i++;
            if (i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;    // 这里比较关键，这样可以防止出现环形数组。
    }
    // 方法二: 寻找链表中点，反转链表。不容易想到，太强了
    public void reorderList3(ListNode head) {
        if (head == null) return;
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        l2 = reverseList(l2);
        merge(l1,l2);
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null){
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head) {
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

}

