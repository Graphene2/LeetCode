package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:该题表达的意思就是 ：相当给你一个S和一个T，请问你S中是否存在一个子串，包含T中所有字符且不包含其他字符？
 * User: zhangcheng
 * Date: 2020-12-11
 * Time: 10:40
 */
public class lc567字符串的排列 {
    Map<Character,Integer> need = new HashMap<>(), window = new HashMap<>();
    public boolean checkInclusion(String s1, String s2) {
        // 将need表填满
        for (char cc : s1.toCharArray()){
            need.put(cc,need.getOrDefault(cc,0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()){
            char ch = s2.charAt(right);
            right++;
            if (need.containsKey(ch)){
                window.put(ch,window.getOrDefault(ch,0) + 1);
                if (window.get(ch).equals(need.get(ch))){
                    valid++;
                }
            }
            while (right - left >= s1.length()){
                if (valid == need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
