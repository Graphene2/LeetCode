package time_NOV;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-27
 * Time: 8:55
 */
public class lc454四数相加II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-(c + d))) {
                    res += map.get(-(c + d));
                }
            }
        }
        return res;
    }
}
