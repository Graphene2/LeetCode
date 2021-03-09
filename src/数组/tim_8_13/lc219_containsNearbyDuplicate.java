package 数组.tim_8_13;


import java.util.HashSet;
import java.util.Set;

/**
 * leetcode219: 存在重复元素2  寻找重复元素的最近距离 比较难
 *
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 21:25
 */
public class lc219_containsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;

    }
}
