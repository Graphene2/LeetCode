package time_Oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-27
 * Time: 17:34
 */
public class hard_lc30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int oneWorld = words[0].length();
        int worldNum = words.length;
        int allLen = oneWorld * worldNum;
        for (String str : words){
            map.put(str,map.getOrDefault(str,0) + 1);
        }
        for (int i = 0; i < oneWorld; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tempMap = new HashMap<>();
            while (right + oneWorld <= s.length()){
                String w = s.substring(right,right + oneWorld);
                right += oneWorld;
                if (!map.containsKey(w)){
                    count = 0;
                    left = right;
                    tempMap.clear();
                }else {
                    count++;
                    tempMap.put(w,tempMap.getOrDefault(w,0) + 1);
                    while (tempMap.getOrDefault(w,0) > map.getOrDefault(w,0)){
                        String tw = s.substring(left,left + oneWorld);
                        count--;
                        tempMap.put(tw,tempMap.getOrDefault(tw,0) - 1);
                        left += oneWorld;
                    }
                    if (count == worldNum) res.add(left);
                }
            }
        }
        return res;
    }
}
