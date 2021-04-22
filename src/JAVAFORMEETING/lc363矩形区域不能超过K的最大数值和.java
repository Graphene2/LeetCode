package JAVAFORMEETING;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-04-22
 * Time: 15:18
 */
public class lc363矩形区域不能超过K的最大数值和 {
    // 采用四元dp数组表示左上到右下角矩形和。
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        int[][][][] dp = new int[rows + 1][cols + 1][rows + 1][cols + 1];
        for(int i1 = 1; i1 <= rows; i1++){
            for(int j1 = 1; j1 <= cols; j1 ++){
                dp[i1][j1][i1][j1] = matrix[i1 - 1][j1 - 1];
                for(int i2 = i1; i2 <= rows; i2++){
                    for(int j2 = j1; j2 <= cols; j2++){
                        dp[i1][j1][i2][j2] = dp[i1][j1][i2 - 1][j2] + dp[i1][j1][i2][j2 - 1] - dp[i1][j1][i2 - 1][j2 - 1] + matrix[i2-1][j2-1];
                        if (dp[i1][j1][i2][j2] <= k && dp[i1][j1][i2][j2] > max){
                            max = dp[i1][j1][i2][j2];
                        }
                    }
                }
            }
        }
        return max;
    }
    // 优化，每次左上角的位置都不变进行的遍历，那么我们在确定了左上角之后再创建dp数组。
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for(int i1 = 1; i1 <= rows; i1++){
            for(int j1 = 1; j1 <= cols; j1 ++){
                int[][] dp = new int[rows + 1][cols + 1];
                dp[i1][j1] = matrix[i1 - 1][j1 - 1];
                for(int i2 = i1; i2 <= rows; i2++){
                    for(int j2 = j1; j2 <= cols; j2++){
                        dp[i2][j2] = dp[i2-1][j2] + dp[i2][j2-1] - dp[i2-1][j2-1] +matrix[i2-1][j2-1];
                        if (dp[i2][j2] <= k && dp[i2][j2] > max){
                            max = dp[i2][j2];
                        }
                    }
                }
            }
        }
        return max;
    }

    // 因为最终的结果为寻找最大值，从小正方形遍历的结果不需要进行再次的遍历，直接进行下一次的结果寻找就行了。
    // 我们采用sumRow累计行总和。
    public int maxSumSubmatrix3(int[][] matrix, int k){
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for (int l = 0; l < cols; l++) {
            // 时间：O(cols ^ 2 * rows)
            int[] rowSum = new int[rows];
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(dpmax(rowSum,k),max);
            }
        }
        return max;
    }

    private int dpmax(int[] nums, int k) {
        // 时间：O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < nums.length; l++) {
            int sum = 0;
            for (int r  = l; r  < nums.length; r ++) {
                sum += nums[r];
                if (sum > max && sum <= k){
                    max = sum;
                }
            }
        }
        return max;
    }
    // 这里的dpmax属于暴力解法，优化如下
    private int dpmax2(int[] arr, int k){
        int rollSum = arr[0], rollMax = rollSum;
        // O(rows)
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) rollSum += arr[i];
            else rollSum = arr[i];
            if (rollSum > rollMax) rollMax = rollSum;
        }
        if (rollSum <= k) return rollMax;

        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k){
                    max = sum;
                }
                if (max == k) return k;
            }
        }
        return max;
    }

}
