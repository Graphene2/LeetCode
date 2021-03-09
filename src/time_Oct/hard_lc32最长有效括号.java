package time_Oct;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-27
 * Time: 19:03
 */
public class hard_lc32最长有效括号 {
    public int longestValidParentheses(String s) {
        int maxAns = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ?dp[i - 2] : 0) + 2;
                }else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxAns = Math.max(maxAns, dp[i]);
            }
        }
        return maxAns;
    }
    // 采用栈的方式
    public int longestValidParentheses2(String s) {
        int maxAns = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                // ')'时
                stack.poll();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }
    // 空间复杂度为1
    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxlength = Math.max(maxlength,right + left);
            }else if (right > left){
                right = 0;
                left = 0;
            }
        }
        left = 0;right = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxlength = Math.max(maxlength,right + left);
            }else if (left > right){
                right = 0;
                left = 0;
            }
        }
        return maxlength;
    }
}
