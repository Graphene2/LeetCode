package DEC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-16
 * Time: 8:49
 */
public class lc290单词规律 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] str = s.split(" ");
        if (str.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)){
                if (!map.get(key).equals(str[i])){
                    return false;
                }
            }else {
                if (set.contains(str[i])){
                    return false;
                }
                map.put(key,str[i]);
                set.add(str[i]);
            }
        }
        return true;
    }
}
