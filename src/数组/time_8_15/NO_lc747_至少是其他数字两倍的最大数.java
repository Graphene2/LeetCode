package 数组.time_8_15;

/**leetcode747: 至少是其他数字两倍的最大数 太简单了
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,19:42
 * @version: 1.0
 */
public class NO_lc747_至少是其他数字两倍的最大数 {
    public int dominantIndex(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= max1){
                max2 = max1;
                max1 = nums[i];
                index = i;
            }else if (nums[i] >= max2){
                max2 = nums[i];
            }
        }
        if (max1 >= max2 * 2){
            return index;
        }else return -1;
    }
}
