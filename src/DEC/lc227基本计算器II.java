package DEC;

import java.util.Stack;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-10
 * Time: 16:44
 */
public class lc227基本计算器II {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                num = num * 10 + (int)(ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ')|| i == s.length() - 1){
                int pre;
                switch (sign){

                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                // 每次使用的sign都是num之前的sign。
                sign = ch;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
