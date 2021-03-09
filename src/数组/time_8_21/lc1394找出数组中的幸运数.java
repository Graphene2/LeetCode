package 数组.time_8_21;

import java.util.HashMap;
import java.util.Map;

/**lc1394找出数组中的幸运数
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/21 9:31
 */
public class lc1394找出数组中的幸运数 {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        int max = 0;
        for (int item:map.keySet()) {
            if (item == map.get(item))
                max = Math.max(max, item);
        }
        return max == 0 ? -1 : max ;
    }
}
