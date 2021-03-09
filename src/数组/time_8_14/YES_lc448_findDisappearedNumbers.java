package 数组.time_8_14;

import java.util.ArrayList;
import java.util.List;

/**leetcode448: 找到所有数组中消失的数字 方法很巧妙！！！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,20:21-20:50
 * @version: 1.0
 */
public class YES_lc448_findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}
