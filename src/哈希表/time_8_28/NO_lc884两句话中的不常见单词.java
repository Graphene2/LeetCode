package 哈希表.time_8_28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,19:35-19:47
 * @version: 1.0
 */
public class NO_lc884两句话中的不常见单词 {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String e : A.split(" ")){
            map.put(e,map.getOrDefault(e,0) + 1);
        }
        for (String e: B.split(" ")){
            map.put(e,map.getOrDefault(e,0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (String e:map.keySet()){
            if (map.get(e) == 1){
                ans.add(e);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
