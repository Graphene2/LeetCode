package 数组.time_8_23;

import java.util.HashMap;
import java.util.Map;

/**lc1460通过翻转子数组使两个数组相等
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/23,10:51-11:03
 * @version: 1.0
 */
public class NO_lc1460通过翻转子数组使两个数组相等 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item: target){
            map.put(item,map.getOrDefault(item, 0) + 1);
        }
        for(int mm:arr){
            if (!map.containsKey(mm) || map.get(mm) <= 0){
                return false;
            }else {
                map.put(mm, map.get(mm) - 1);
            }
        }return true;
    }
}
