package JAVAFORMEETING;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-20
 * Time: 10:54
 */
public class lc150逆波兰表达式 {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                stack.addLast(Integer.valueOf(tokens[i]).intValue());
            }else {
                int tmp1 = stack.pollLast();
                int tmp2 = stack.pollLast();
                if (tokens[i].equals("+")){
                    stack.addLast(tmp1 + tmp2);
                }else if (tokens[i].equals("-")){
                    stack.addLast(tmp2 - tmp1);
                }else if (tokens[i].equals("*")){
                    stack.addLast(tmp1 * tmp2);
                }else {
                    stack.addLast(tmp2 / tmp1);
                }
            }
        }
        return stack.pollLast();
    }

    public static void main(String[] args) {
        String[] str = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        evalRPN(str);
    }
}
