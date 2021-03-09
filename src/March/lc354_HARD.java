package March;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-04
 * Time: 14:58
 */
public class lc354_HARD {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0){
            return 0;
        }
        int len = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });

        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int ans = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
