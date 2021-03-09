package DEC;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-04
 * Time: 9:59-10:56
 */
public class lc659分割数组为连续子序列 {

    public boolean isPossible(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0){
            return false;
        }
        Map<Integer,Integer> count = new HashMap<>();
        Map<Integer,Integer> tail = new HashMap<>();
        for (int m: nums) {
            count.put(m,count.getOrDefault(m,0) + 1);
        }
        for (int num: nums) {
            if (count.get(num) <= 0){
                continue;
                // 如果存在以num - 1为结尾的tail的值，
                // tail中 num - 1 频次 - 1;
                // tail中 num 频次 + 1;
                // count中 num 频次 - 1;
            }else if (tail.getOrDefault(num - 1,0) > 0){
                tail.put(num,tail.getOrDefault(num,0) + 1);
                tail.put(num - 1,tail.get(num - 1) - 1);
                count.put(num,count.get(num) - 1);
                // 如果count 中 num + 1, num + 2 均存在
                // count 中 num 频次 - 1;
                // count 中 num + 1 频次 - 1
                // count 中 num + 2 频次 - 1
                // tail 中 num + 2 频次 + 1
            }else if (count.getOrDefault(num + 1, 0) > 0 && count.getOrDefault(num + 2, 0) > 0)
            {
                count.put(num + 2,count.get(num + 2) - 1);
                count.put(num + 1,count.get(num + 1) - 1);
                count.put(num,count.get(num) - 1);
                tail.put(num + 2,tail.getOrDefault(num + 2,0) + 1);
            }else {
                return false;
            }
        }
        return true;
    }

}
