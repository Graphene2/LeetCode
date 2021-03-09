package DEC;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-07
 * Time: 8:44
 */
public class lc861 {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int res = m * (1 << (n - 1));
        for (int j = 1; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1){
                    count += A[i][j];
                }else {
                    count += 1 - A[i][j];
                }
            }
            int k = Math.max(count, m - count);
            res += k * (1 << (n - j - 1));
        }
        return res;
    }
}
