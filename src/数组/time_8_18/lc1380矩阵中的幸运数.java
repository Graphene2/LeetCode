package 数组.time_8_18;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**leetcode1380矩阵中的幸运数
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/18 17:11-17:29
 */
public class lc1380矩阵中的幸运数 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++){
            int min = matrix[i][0];
            int k = 0;
            for (int j = 0; j < n; j++){
                if (matrix[i][j] < min){
                    min = matrix[i][j];
                    k = j;
                }
            }
            int x = 0;
            for (x = 0; x < m; x++){
                if (matrix[x][k] > min ) break;
            }
            if (x == m) ans.add(min);
        }return ans;
    }
}
