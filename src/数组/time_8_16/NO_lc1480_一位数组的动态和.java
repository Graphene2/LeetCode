package 数组.time_8_16;

/**leetcode1480: 一位数组的动态和
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,14:38
 * @version: 1.0
 */
public class NO_lc1480_一位数组的动态和 {
    public int[] runningSum(int[] nums) {
        if (nums.length == 0) return nums;

        for (int i = 1; i < nums.length; i++){
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
