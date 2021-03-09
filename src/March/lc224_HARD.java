package March;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-10
 * Time: 14:35
 */
public class lc224_HARD {
    public int calculate(String s) {
        // res 保存当前左括号开始的结果，num 保存符号前一个数字, sigh 保存符号信息
        int res = 0, num = 0, sign = 1;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = 10 * num + c - '0';
            }else if (c == '+' || c == '-'){
                res += sign * num;
                num = 0;
                // 确定下一步的符号
                if (c == '+'){
                    sign = 1;
                }else if (c == '-'){
                    sign = -1;
                }
            }else if (c == '('){
                stack.addLast(res);
                stack.addLast(sign);
                res = 0;
                sign = 1;
            }else if (c == ')'){
                // 先算括号里面的。
                res += sign * num;
                num = 0;
                res = res * stack.pollLast();
                sign = 1;
                res += stack.pollLast();
            }

        }
        res += sign * num;
        return res;
    }
}
