package 数组.time_8_20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**剑指offer03数组中重复的数字  建议用三种方法进行 其中每种方法都用O(1)的空间复杂度！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/20 16:56
 */
public class YES_剑指offer03数组中重复的数字 {
    public int findRepeatNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int tem: nums){
            map.put(tem, map.getOrDefault(tem, 0) + 1);
            if (map.get(tem) > 1){
                return tem;
            }
        }return -1;
    }

    // 用Hashset返回boolean判断是否已经加入过Hashset
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int item: nums){
            if (!set.add(item)){
                return item;
            }
        }return -1;
    }
    // 交换nums[i]到其该有的位置i,直到碰到相同的数，原地置换的思想很常见，多总结！
    public int findRepeatNumber3(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }else {
                    int temp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[nums[i]] = temp;
                }
            }
        }return -1;
    }

}
