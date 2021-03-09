package significance.time_Sep.time_9_11;

import java.util.Arrays;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 16:49-16:56
 */
public class lc453最小移动次数使数组元素相等 {
    // 经典的数学方法:把加法看成减法！
    public int minMoves(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            min = Math.min(min,nums[i]);
            sum += nums[i];
        }
        return sum - min * nums.length;
    }
    // 动态规划！！！！！
    public int minMoves2(int[] nums){
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i - 1];
            nums[i] += moves;
            moves += diff;
        }
        return moves;
    }
}
