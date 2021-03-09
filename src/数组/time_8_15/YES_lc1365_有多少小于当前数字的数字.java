package 数组.time_8_15;

/**leetcode1365: 有多少小于当前数字的数字  桶排序。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,0:01
 * @version: 1.0
 */
public class YES_lc1365_有多少小于当前数字的数字 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = new int[101];
        for (int item: nums){
            temp[item]++;
        }
        int[] arr = new int[nums.length];
        for (int i = 1; i < 101; i++){
            temp[i] += temp[i - 1];
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0)
                arr[i] = temp[nums[i] - 1];
        }

        return arr;
    }
    // 方法二：
}
