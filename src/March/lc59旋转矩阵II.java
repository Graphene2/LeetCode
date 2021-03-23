package March;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-16
 * Time: 9:41
 */
public class lc59旋转矩阵II {
    public int[][] generateMatrix(int n) {
        int t = 0, d = n - 1, l = 0, r = n - 1;
        int[][] matrix = new int[n][n];
        int num = 1, sum = n * n;
        while (num <= sum){
            for (int i = l; i <= r; i++) {
                matrix[t][i] = num++;
            }
            t++;
            for (int i = t; i <= d; i++) {
                matrix[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l ; i--) {
                matrix[d][i] = num++;
            }
            d--;
            for (int i = d; i >= t ; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }
        return matrix;
    }
}
