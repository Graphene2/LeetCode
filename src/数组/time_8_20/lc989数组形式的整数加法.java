package 数组.time_8_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**lc989数组形式的整数加法
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/20 10:55
 */
public class lc989数组形式的整数加法 {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int curr = K;
        List<Integer> ans = new ArrayList<>();

        int i = N - 1;
        while (i >= 0 || curr > 0) {
            if (i >= 0)
                curr += A[i];
            ans.add(curr % 10);
            curr /= 10;
            i--;
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,0,0};
        int k = 34;
        List<Integer> ans = addToArrayForm(A, k);
        for (int m :ans){
            System.out.print(m+"\t");
        }
    }
}
