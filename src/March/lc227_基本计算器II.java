package March;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-11
 * Time: 11:04
 */
public class lc227_基本计算器II {
    public int calculate(String s) {
        int num = 0;
        char preSign = '+';
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = 10 * num + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1){
                switch (preSign){
                    case '+' :
                        stack.addLast(num);
                        break;
                    case '-' :
                        stack.addLast(-num);
                        break;
                    case '*' :
                        stack.addLast(stack.pollLast() * num);
                        break;
                    case '/' :
                        stack.addLast(stack.pollLast() / num);
                        break;
                }
                preSign = s.charAt(i);
                num = 0;
            }

        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pollLast();
        }
        return res;
    }
}
