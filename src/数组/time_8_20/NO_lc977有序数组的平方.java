package 数组.time_8_20;

import java.util.Map;

/**lc977有序数组的平方
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/20 9:12
 */
public class NO_lc977有序数组的平方 {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int i = 0;
        while (i < N && A[i] < 0){
            i++;
        }
        int m = i - 1;

        int t = 0;
        int[] ans = new int[N];

        while (m >= 0 && i < N) {
            if (A[m] * A[m] < A[i] * A[i]) {
                ans[t++] = A[m] * A[m];
                m--;
            } else {
                ans[t++] = A[i] * A[i];
                i++;
            }
        }
            while (m >= 0){
                ans[t++] = A[m] * A[m];
                m--;
            }
            while (i < N){
                ans[t++] = A[i] * A[i];
                i++;
            }
        return ans;
    }
}
