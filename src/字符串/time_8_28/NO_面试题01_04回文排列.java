package 字符串.time_8_28;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,13:00
 * @version: 1.0
 */
public class NO_面试题01_04回文排列 {
    public boolean canPermutePalindrome(String s) {
        // 建立字符串s的map
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int oddCount = 0;
        for (int x : map.values()) {
            if (x % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount > 1){
            return false;
        }else return true;
    }
}
