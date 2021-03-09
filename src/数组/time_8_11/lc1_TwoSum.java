package 数组.time_8_11;

import java.util.HashMap;
import java.util.Map;

/**leetcode1: 两数之和第一题： Hashmap的方法需要熟悉，该题目很经典！
 * 常见Hashmap函数： 1.containKey(key):boolean  2.get(key):value   3.put(key,value)
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/11,21:02
 * @version: 1.0
 */
public class lc1_TwoSum {
    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i < nums.length ; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

