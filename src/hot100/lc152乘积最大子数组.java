package hot100;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-25
 * Time: 10:27
 */
public class lc152乘积最大子数组 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0){
            return 0;
        }
        int[][] dp = new int[len][2];
        // dp[i][1] 表示以num[i]结尾的连续子数组乘积的最大值
        // dp[i][0] 表示以num[i]结尾的连续子数组乘积的最大值
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0){
                dp[i][0] = Math.min(nums[i],dp[i - 1][0] * nums[i]);
                dp[i][1] = Math.max(nums[i],dp[i - 1][1] * nums[i]);
            }else {
                dp[i][0] = Math.min(nums[i],dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.max(nums[i],dp[i - 1][0] * nums[i]);
            }
            res  = Math.max(res,dp[i][1]);
        }
        return res;
    }
    // 优化！该题的状态为巫后效性，只与上一次的状态有关。
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0){
            return 0;
        }
        int preMin = nums[0];
        int preMax = nums[0];
        int curMax,curMin;
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0){
                curMin = Math.min(nums[i],preMin * nums[i]);
                curMax = Math.max(nums[i],preMax * nums[i]);
            }else {
                curMin = Math.min(nums[i],preMax * nums[i]);
                curMax = Math.max(nums[i],preMin * nums[i]);
            }
            res  = Math.max(res,curMax);
            preMin = curMin;
            preMax = curMax;
        }
        return res;
    }
}
