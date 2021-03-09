package 字符串.time_8_26;

import java.util.Stack;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/26,21:49
 * @version: 1.0
 */
public class YES_lc20有效的括号 {
    public boolean isValid(String s) {
        if (s.length() == 0 || s == null) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            if (isCorrespond(stack.peek(), s.charAt(i))){
                stack.pop();
            }else if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ){
                stack.push(s.charAt(i));
            }
            if (i == s.length() - 1 && stack.isEmpty()){
                return true;
            }
        }return false;
    }

    private boolean isCorrespond(Character peek, char ch) {
        if (peek == '(' && ch == ')' || peek == '[' && ch == ']' || peek == '{' && ch == '}'){
            return true;
        }else return false;
    }
}
