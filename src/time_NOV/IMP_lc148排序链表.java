package time_NOV;

import LinkedList.ListNode;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-13
 * Time: 9:44
 */
public class IMP_lc148排序链表 {
    // 递归+归并，因为递归栈需要占据额外的空间，故而空间复杂度不为常数级别。O(logn)
    // 这里的递归写的很精彩，值得学习！
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode left = sortList(head);
        ListNode right = sortList(findMid(head));
        return merge(left,right);
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode ret = slow.next;
        slow.next = null;
        return ret;
    }

    // 归并+迭代，方法很值得借鉴！
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null ) return head;
        int len = 0;
        ListNode p = head;
        while (p != null){
            len++;
            p = p.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int i = 1; i < len; i *= 2) {
            ListNode cur = dummy.next;
            ListNode tail = dummy;
            while (cur != null){
                ListNode left = cur;
                ListNode right = cut(left,i);
                cur = cut(right,i);
                tail.next = merge(left, right);
                // tail 排到已排序数组的队尾。
                while(tail.next != null) tail = tail.next;
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    private ListNode cut(ListNode head, int n) {
        while (head != null && n > 1){
            head = head.next;
            n--;
        }
        if (head == null) return null;
        ListNode ret = head.next;
        // 断开链表，方便后面merge的链接。
        head.next = null;
        return ret;
    }
    // 字节面试用快排写链表排序！
    public ListNode sortList3(ListNode head) {
        return sort(head)[0];
    }

    private ListNode[] sort(ListNode head) {
        if(head == null || head.next == null){
            return new ListNode[]{head,head};
        }
        ListNode[][] parAns = partition(head);
        ListNode[] left = sort(parAns[0][0]);
        ListNode[] right = sort(parAns[2][0]);
        if (left[1] != null){
            left[1].next = parAns[1][0];
            parAns[1][1] = parAns[1][1] == null ? left[1] : parAns[1][1];
        }
        if (parAns[1][1] != null){
            parAns[1][1].next = right[0];
        }
        ListNode pL, pR;
        if (left[0] != null){
            pL = left[0];
        }else {
            if (parAns[1][0] != null){
                pL = parAns[1][0];
            }else {
                pL = right[0];
            }
        }
        if (right[1] != null){
            pR = right[1];
        }else {
            if (parAns[1][1] != null){
                pR = parAns[1][1];
            }else {
                pR = left[1];
            }
        }
        return new ListNode[]{pL,pR};

    }

    private ListNode[][] partition(ListNode head) {
        ListNode leftHead = null,equalHead = null,rightHead = null,
                leftTail = null, equalTail = null, rightTail = null,next;
        ListNode p = head;
        int base = p.val;
        while (p != null) {
            next = p.next;
            if (p.val < base) {
                if (leftHead == null){
                    leftHead = p;
                    leftTail = p;}
                else {
                    leftTail.next = p;
                    leftTail = leftTail.next;
                }
            }else if (p.val > base){
                if (rightHead == null){
                    rightHead = p;
                    rightTail = p;
                }
                else {
                    rightTail.next = p;
                    rightTail = rightTail.next;
                }
            }else {
                if (equalHead == null){
                    equalHead = p;
                    equalTail = p;}
                else {
                    equalTail.next = p;
                    equalTail = equalTail.next;
                }
            }
            p.next = null;
            p = next;
        }
        return new ListNode[][]{{leftHead,leftTail},{equalHead,equalTail},{rightHead,rightTail}};
    }

}


