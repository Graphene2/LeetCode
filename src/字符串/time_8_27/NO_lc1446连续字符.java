package 字符串.time_8_27;

import java.util.Map;

/** 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串的能量。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 9:34-9:47
 */
public class NO_lc1446连续字符 {
    // 双指针
    public int maxPower(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int start = 0,max = 0;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) != s.charAt(start)){
                max = Math.max(max, i - start);
                start = i;
            }
            if (i == s.length() - 1){
                max = Math.max(max, i - start);
            }
        }return max;
    }
}
