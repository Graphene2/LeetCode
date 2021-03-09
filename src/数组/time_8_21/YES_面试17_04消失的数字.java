package 数组.time_8_21;

/**面试17_04消失的数字
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/21 10:13
 */
public class YES_面试17_04消失的数字 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = n;
        for (int i = 0; i < n; i++){
            missing ^= nums[i] ^ i;
        }return missing;
    }
}
