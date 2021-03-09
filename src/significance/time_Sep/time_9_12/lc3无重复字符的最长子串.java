package significance.time_Sep.time_9_12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/12 14:18
 */
public class lc3无重复字符的最长子串 {

    public static int lengthOfLongestSubstring(String s) {
        // 方法一: 滑动窗口！
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++){
            if (i != 0){
                // 左指针向右移动一格，移除一个字符。
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))){
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int m = lengthOfLongestSubstring("abcabcbb");
        System.out.println(m);
    }
    // 使用Map方法也是可以的
    public static int lengthOfLongestSubstring2(String s){
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, n = s.length();
        int left = 0;
        for (int i = 0; i < n; i++){
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i - left + 1);
        }
        return max  ;
    }
}
