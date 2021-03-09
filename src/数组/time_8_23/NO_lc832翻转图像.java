package 数组.time_8_23;

import com.sun.source.tree.BreakTree;

import java.util.Objects;

/**lc832翻转图像
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/23,10:31-10:48
 * @version: 1.0
 */
public class NO_lc832翻转图像 {
    public static int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            int j = 0, k = n - 1;
            while (j < k) {
                if (A[i][j] == 0 && A[i][k] == 0) {
                    A[i][j] = A[i][k] = 1;
                }else if (A[i][j] == 1 && A[i][k] == 1) {
                    A[i][j] = A[i][k] = 0;
                }
                j++;
                k--;
            }
            if (j == k) {
                A[i][j] = A[i][j] ^ 1;
            }
        }
        return A;
    }
}
