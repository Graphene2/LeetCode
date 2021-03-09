package 哈希表.time_8_29;

import java.util.HashMap;
import java.util.Map;

/** 可以优化，具体进行
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/29,14:31
 * @version: 1.0
 */
public class NO_lc771宝石与石头 {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (char e: S.toCharArray()){
            map.put(e,map.getOrDefault(e,0) + 1);
        }
        for (char e:J.toCharArray()){
            if (map.containsKey(e)){
                ans += map.get(e);
            }
        }
        return ans;
    }
}
