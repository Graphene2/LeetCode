package 数组.time_8_17;

import java.util.HashMap;
import java.util.Map;

/**leetcode1513 好数对的数目。 简单的过分了
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/17 12:35
 */
public class NO_lc1512好数对的数目 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int sum = 0;
        for (int key:map.keySet()){
            int value = map.get(key);
            if (value > 1) {
                sum += (value - 1) * value / 2;
            }
        }return sum;
    }
}
