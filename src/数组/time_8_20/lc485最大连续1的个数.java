package 数组.time_8_20;

import java.awt.event.MouseAdapter;
import java.util.Map;

/**lc485最大连续1的个数 或者采用双指针！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/21 9:49
 */
public class lc485最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                count++;
            }else count = 0;
            max = Math.max(max, count);
        }return max;
    }
}
