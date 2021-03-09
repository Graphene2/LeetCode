package 数组.time_8_20;

/**lc985查询后的偶数和
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/20,22:04
 * @version: 1.0
 */
public class NO_lc985查询后的偶数和 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++){
            if (A[i] % 2 == 0){
                sum += A[i];
            }
        }
        for (int i = 0; i < queries.length; i++){
            int temp = A[queries[i][1]];
            A[queries[i][1]] += queries[i][0];
            if (A[queries[i][1]] % 2 == 0 && temp % 2 != 0){
                sum += A[queries[i][1]];
            }else if (A[queries[i][1]] % 2 == 0 && temp % 2 == 0){
                sum += A[queries[i][1]] - temp;
            }else if (A[queries[i][1]] % 2 != 0 && temp % 2 == 0){
                sum -= temp;
            }
            ans[i] = sum;
        }return ans;
    }
}
