package 数组.time_8_19;

import java.util.HashMap;
import java.util.Map;

/**lc217存在重复的元素
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 17:10
 */
public class NO_lc217存在重复的元素 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i]))return true;
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        return false;
    }
}
