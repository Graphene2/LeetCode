package 数组.time_8_16;

/**leetcode1464: 数组中两元素的最大乘积
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,21:39
 * @version: 1.0
 */
public class NO_lc1464数组中两元素的最大乘积 {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
            }else if (nums[i] > max2){
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}
