package DP;

/**
 * Description:lc416分割等和子集
 * User: zhangcheng
 * Date: 2020-10-09
 * Time: 15:14
 */
public class 分割等和子集__01背包问题变体 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int m : nums){
            sum += m;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];

        dp[0][0] = true;

        if (nums[0] <= sum){
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++){
            for (int j = 0; j <= sum; j++){
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            // 剪枝策略，当已经能找到和为该target的数。
            if (dp[i][sum]){
                return true;
            }
        }

        // 打印状态转移表！
        System.out.print(" \t\t");
        for (int i = 0; i <= sum; i++){
            System.out.print(i + "\t\t");
        }
        System.out.println();
        for (int i = 0; i < n; i++){
            System.out.print("nums["+ i +"]\t");
            for (int j = 0; j <= sum; j++){
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[n - 1][sum];
    }
    // 观察状态转移方程可以知道，当前状态都是由上一个状态转换过来的，故而可以用一维数组表示状态表
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int m : nums){
            sum += m;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1; i < n; i++){
            for (int j = sum; j >= 0; j--){

                if (j - nums[i - 1] >= 0){
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3,5};
        分割等和子集__01背包问题变体 m = new 分割等和子集__01背包问题变体();
        m.canPartition(nums);
    }
}
