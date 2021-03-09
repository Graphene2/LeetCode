package DEC;

/**
 * Description: 简单DP！
 * User: zhangcheng
 * Date: 2020-12-07
 * Time: 15:55
 */
public class lc221最大正方形 {
    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return maxSize;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] =='1'){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]),dp[i][j - 1]);
                    }
                    maxSize = Math.max(maxSize,dp[i][j]);
                }
            }
        }
        return maxSize * maxSize;
    }
}
