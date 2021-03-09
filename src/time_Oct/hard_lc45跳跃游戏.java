package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-28
 * Time: 8:56
 */
public class hard_lc45跳跃游戏 {
    public int jump(int[] nums) {
        // dp[i] 为到达i位置所需要的的最小跳跃次数。超时！
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                for (int j = 1; j <= nums[i]; j++) {
                    if (j + i < n && dp[j + i] > 0){
                        dp[j + i] = Math.min(dp[j + i],dp[i] + 1);
                    }else if (j + i < n && dp[j + i] == 0){
                        dp[j + i] = dp[i] + 1;
                    }
                }
            }
        }
        return dp[n - 1];
    }
    // 正向查找可到达的最大位置
    public int jump2(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxPos = 0;
        int steps = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPos = Math.max(maxPos,i + nums[i]);
            if (i == end){
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }
}
