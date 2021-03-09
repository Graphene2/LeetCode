package 数组.time_8_12;

/**leetcode53: 最大子序和
 * 1.动态规划思想：
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/12,23:28
 * @version: 1.0
 */
public class lc53_maxSubArray {
    //1. 采用动态规划算法实现
    public static int maxSubArray1(int[] nums){
        int max = nums[0];
        int sum = 0;
        for (int num:nums){
            if (sum > 0){
                sum += num;
            }
            else sum = num;
            max = Math.max(sum,max);
        }
        return max;
    }
    // 常规动态规划
    public static int maxSubArray(int[] nums){
        int m = nums.length;
        int[] dp = new int[m];
        dp[0] = nums[0];
        for (int i = 1; i < m; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = nums[0];
        for (int i = 0; i < m; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
