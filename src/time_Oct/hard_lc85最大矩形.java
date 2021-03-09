package time_Oct;

import java.util.Arrays;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-30
 * Time: 10:16
 */
public class hard_lc85最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] right = new int[n];
        int[] left = new int[n];
        int[] high = new int[n];
        Arrays.fill(right, n);

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int curLeft = 0;
            int curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') high[j]++;
                else high[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    left[j] = Math.max(left[j],curLeft);
                }else {
                    left[j] = 0;curLeft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1'){
                    right[j] = Math.min(right[j],curRight);
                }else {
                    right[j] = n; curRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea,(right[j] - left[j]) * high[j]);
            }
        }
        return maxArea;
    }

    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int width = dp[i][j];
                    for(int k = i; k >= 0; k--){
                        width = Math.min(width, dp[k][j]);
                        maxarea = Math.max(maxarea, width * (i - k + 1));
                    }
                }
            }
        }
        return maxarea;
    }
}
