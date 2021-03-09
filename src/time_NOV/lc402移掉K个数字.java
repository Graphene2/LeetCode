package time_NOV;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:第二遍
 * User: zhangcheng
 * Date: 2020-11-15
 * Time: 13:24
 */
public class lc402移掉K个数字 {
    public  String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int len = num.length();
        if (len < k){
            return "0";
        }
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit){
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        // 开始处理前置0
        boolean Zero = true;
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()){
            char digit = deque.pollFirst();
            if (Zero && digit == '0'){
                continue;
            }
            Zero = false;
            res.append(digit);
        }
        return res.length() == 0 ? "0" : res.toString();
    }

}
