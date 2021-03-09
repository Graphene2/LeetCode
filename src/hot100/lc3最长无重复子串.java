package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-11
 * Time: 9:38
 */
public class lc3最长无重复子串 {
    public  int lengthOfLongestSubstring(String s){
        if (s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int max = 0, n = s.length();
        int left = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                left = Math.max(left,map.get(ch) + 1);
            }
            map.put(ch,i);
            max = Math.max(max,i - left + 1);
        }
        return max;
    }
}
