package 数组.time_8_23;

import java.util.ArrayList;
import java.util.List;

/**lc1389按既定顺序创建目标数组
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/23,9:43-9:54
 * @version: 1.0
 */
public class NO_lc1389按既定顺序创建目标数组 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(index[i],nums[i]);
        }
        for (int i = 0; i < n; i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
}
