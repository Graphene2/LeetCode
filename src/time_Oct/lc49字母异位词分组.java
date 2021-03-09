package time_Oct;

import java.util.*;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/10/7,23:39
 * @version: 1.0
 */
public class lc49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        Map<String,List> map = new HashMap<>();
        for (String str : strs){
            char[] ccs = str.toCharArray();
            Arrays.sort(ccs);
            String tmp = String.valueOf(ccs);
            if (!map.containsKey(tmp)){
                map.put(tmp,new ArrayList());
            }
            map.get(tmp).add(str);

        }
        return new ArrayList(map.values());
    }
}
