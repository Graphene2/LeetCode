package 数组.tim_8_13;

import java.util.HashMap;
import java.util.Map;

/**leetcode697: 数组的度
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 14:46
 */
public class lc697_findShortestSubArray {
    public static int findShortestSubArray(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        };
        if (nums.length == 1){
            return 1;
        }
        Map<Integer,Integer> leftMap = new HashMap<>(), rightMap = new HashMap<>(),countMap = new HashMap<>();
        for (int i=0 ; i < nums.length ; i++){
            // countMap存放数组中每个元素出现的次数
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if (!leftMap.containsKey(nums[i])){
                // leftMap存放数组中元素第一次出现的位置。
                leftMap.put(nums[i], i);
            }
            // rightMap存放数组中相同元素第一次和最后一次出现的长度。
            rightMap.put(nums[i], i - leftMap.get(nums[i]) +1);
        }
        int maxCount = 0;
        for (int num:countMap.values()){
            maxCount = Math.max(maxCount, num);
        }
        int minLength = Integer.MAX_VALUE;
        for (int key:countMap.keySet()){
            if (maxCount == countMap.get(key)){
                minLength = Math.min(minLength, rightMap.get(key));
            }
        }
        return minLength;
    }
}
