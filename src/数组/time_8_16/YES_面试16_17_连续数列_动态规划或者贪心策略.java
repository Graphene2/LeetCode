package 数组.time_8_16;

/**面试16_17_连续数列 采用DP的方式！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,11:07
 * @version: 1.0
 */
public class YES_面试16_17_连续数列_动态规划或者贪心策略 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
