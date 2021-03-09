package January;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-22
 * Time: 9:55
 */
public class lc989数组形式的整数加法 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int n = A.length;
        for (int i = n - 1; i >= 0; i--) {
            int sum = A[i] + K % 10;
            K /= 10;
            if (sum >= 10){
                K++;
                sum -= 10;
            }
            res.add(sum);
        }
        for (; K > 0; K /= 10) {
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }
}
