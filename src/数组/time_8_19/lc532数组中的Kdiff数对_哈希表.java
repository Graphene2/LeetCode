package 数组.time_8_19;

import com.sun.security.auth.module.LdapLoginModule;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**leetcode532: 数组中的K-diff数对
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 11:12-11:29
 */
public class lc532数组中的Kdiff数对_哈希表 {
    public int findPairs(int[] nums, int k) {
        if (k < 0 ) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i :nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer,Integer> m:map.entrySet()){
            int v = m.getValue();
            int key = m.getKey();
            if (k == 0 && v > 1){
                ans++;
            }else if (k != 0 && map.containsKey(key - k)){
                ans++;
            }
        }return ans;
    }
}
