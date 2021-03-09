package 字符串.time_8_26;


import java.util.Stack;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/26 15:40
 */
public class YES_lc1544整理字符串 {
    public String makeGood(String s) {
        if (s.length() == 1 || s.length() == 0 || s == null) return s;
        Stack<Character> stack = new Stack<>();
        // 遍历s
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            // 若栈为空，直接压栈。
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            // 栈顶元素
            char tmp = stack.peek();
            // 如果当前元素是栈顶元素的大小写，则弹出栈顶元素。
            if (cur - tmp == 32 || tmp - cur == 32){
                stack.pop();
            }else {
                stack.push(cur);
            }
        }
        // 将栈中元素依次弹出反转即可。
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }

}
