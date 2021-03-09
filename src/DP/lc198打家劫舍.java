package DP;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-25
 * Time: 10:44
 */
public class lc198打家劫舍 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
    // 优化，因为无后效性
    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1){
            return nums[0];
        }
        int dp_pre = nums[0];
        int dp_cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = dp_cur;
            dp_cur = Math.max(dp_pre + nums[i], dp_cur);
            dp_pre = temp;
        }
        return dp_cur;
    }
}
