package DP;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-14
 * Time: 17:42
 */
public class lc63不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] ans = new int[n];
        ans[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    ans[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0){
                    ans[j] += ans[j - 1];
                }
            }
        }
        return ans[n - 1];
    }
}
