package 哈希表.time_8_31;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/31 15:38-15:58
 */
public class lc594最长和谐子序列 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int e: nums){
            map.put(e,map.getOrDefault(e,0) + 1);
        }
        for (int key:map.keySet()){
            res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }
    public int findLHS2(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1))
                res = Math.max(res, map.get(num) + map.get(num + 1));
            if (map.containsKey(num - 1))
                res = Math.max(res, map.get(num) + map.get(num - 1));
        }
        return res;
    }

}
