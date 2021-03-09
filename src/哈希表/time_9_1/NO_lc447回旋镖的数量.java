package 哈希表.time_9_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/1 12:46-12:59
 */
class NO_lc447回旋镖的数量 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int dis = distance(points[i], points[j]);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            for (int k : map.values()) {
                if (k >= 2) {
                    res += k * (k - 1);
                }
            }
        }
        return res;
    }

    private int distance(int[] i, int[] j) {
        return ((i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]));
    }
}
