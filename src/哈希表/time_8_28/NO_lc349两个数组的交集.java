package 哈希表.time_8_28;

import java.util.HashSet;
import java.util.Set;

/**  List.toArray只能转化为Integer数组，不能直接转化为int数组！，想要进行转换必须
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,21:01
 * @version: 1.0
 */
public class NO_lc349两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> parentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        for (int num : nums1) {
            parentSet.add(num);
        }
        for (int num : nums2) {
            if (parentSet.contains(num)) {
                childSet.add(num);
            }
        }
        int[] res = new int[childSet.size()];
        int index = 0;
        for (int value : childSet) {
            res[index++] = value;
        }
        return res;
    }
}
