package 数组.time_8_19;

/**leetcode268: 缺失的数字
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 13:56
 */
public class YES_lc268缺失的数字_位运算 {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0 ; i < nums.length; i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
