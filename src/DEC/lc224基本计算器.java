package DEC;

import java.util.Stack;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-10
 * Time: 16:25
 */
public class lc224基本计算器 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int sign = 1;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                operand = operand * 10 + (int)(ch - '0');
            }else if (ch == '+'){
                res += operand * sign;
                sign = 1;
                operand = 0;
            }else if (ch == '-'){
                res += operand * sign;
                sign = -1;
                operand = 0;
            }else if (ch == '('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            }else if (ch == ')'){
                res += sign * operand;
                res *= stack.pop();
                res += stack.pop();
                operand = 0;

            }
        }
        return res + (sign * operand);
    }
}
