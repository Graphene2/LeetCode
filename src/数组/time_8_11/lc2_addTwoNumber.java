package 数组.time_8_11;
/**leetcode2: 两数相加
 * 注意要点： 返回的是
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/11,21:23
 * @version: 1.0
 */
public class lc2_addTwoNumber {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode ans = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curr = ans;
        int carry = 0;
        while (p1 != null || p2 != null){
            int x = (p1 != null)?p1.val : 0;
            int y = (p2 != null)?p2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return ans.next;
    }

}

/**


 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
