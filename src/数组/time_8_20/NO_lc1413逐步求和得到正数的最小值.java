package 数组.time_8_20;

/**lc1413逐步求和得到正数的最小值
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/20 11:27
 */
public class NO_lc1413逐步求和得到正数的最小值 {
    public int minStartValue(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            min = Math.min(min, sum);
        }
        if (min < 0 ) return Math.abs(min) + 1;
        else return 1;
    }
}
