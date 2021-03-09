package significance.time_Sep.time_9_11;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 13:52
 */
public class tst {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(1);
        YES_lc234回文链表 mm = new YES_lc234回文链表();
        boolean m = mm.isPalindrome(head);
        System.out.println(m);
    }
}
