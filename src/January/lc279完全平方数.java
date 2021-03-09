package January;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-14
 * Time: 9:34
 */
public class lc279完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        int maxSquareIndex = (int)Math.sqrt(n) + 1;
        int squareNums[] = new int[maxSquareIndex];
        for (int i = 1; i < maxSquareIndex; i++) {
            squareNums[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < maxSquareIndex; j++) {
                if (i < squareNums[j]){
                    break;
                }
                dp[i] = Math.min(dp[i],dp[i - squareNums[j]] + 1);
            }
        }
        return dp[n];
    }
    // 方法二： 贪心算法
    Set<Integer> squareNums = new HashSet<>();
    public int numSquares2(int n) {
        this.squareNums.clear();

        for (int i = 1; i * i <= n; i++) {
            squareNums.add(i * i);
        }

        int count = 1;
        for (; count <= n ; count++) {
            if (isDividedBy(n,count)){
                return count;
            }
        }
        return count;
    }
    protected boolean isDividedBy(int n, int count){
        if (count == 1){
            return squareNums.contains(n);
        }
        for (Integer square : squareNums) {
            if (isDividedBy(n - square, count - 1)){
                return true;
            }
        }
        return false;
    }
}
