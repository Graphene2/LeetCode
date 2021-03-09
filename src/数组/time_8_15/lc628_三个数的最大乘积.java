package 数组.time_8_15;

/**leetcode628: 三个数的最大乘积 简单题，但是我想复杂了
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,16:30-17:30
 * @version: 1.0
 */
public class lc628_三个数的最大乘积 {
    public int maximumProduct(int[] nums) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > first ){
                third = second;
                second = first;
                first = nums[i];
            }else if (nums[i] > second ){
                third = second;
                second = nums[i];
            }else if (nums[i] > third){
                third = nums[i];
            }
            if (nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }else if (nums[i] < min2){
                min2 = nums[i];
            }
        }
        return Math.max(first * second * third,first * min1 * min2);
    }
}
