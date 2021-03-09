package March;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-01
 * Time: 16:09
 */
public class lc350_EAZY {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n){
            return intersect(nums2,nums1);
        }
        int[] intersection = new int[m];
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num,0) + 1;
            map.put(num,count);
        }
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num,0);
            while (count > 0){
                intersection[index] = num;
                index++;
                count--;
               if (count > 0){
                   map.put(num,count);
               }else {
                   map.remove(num);
               }
            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }
}
