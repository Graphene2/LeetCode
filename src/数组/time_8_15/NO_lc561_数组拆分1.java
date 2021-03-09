package 数组.time_8_15;

import java.util.Arrays;

/**leetcode561: 数组拆分1
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,9:50-10:05
 * @version: 1.0
 */
public class NO_lc561_数组拆分1 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
