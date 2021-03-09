package 剑指offer;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-21
 * Time: 19:09
 */
public class offer14剪绳子 {
    public int cuttingRope(int n) {
        int [] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int tmp = dp[i - j] * dp[j];
                dp[i] = Math.max(dp[i],tmp);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        offer14剪绳子 mm = new offer14剪绳子();
        mm.cuttingRope(2);
    }
}
