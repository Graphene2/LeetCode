package 数组.time_8_15;

/**leetcode1470: 重新排列数组   与lc41 lc287同样的方法。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,17:06
 * @version: 1.0
 */
public class YES_lc1470_重新排列数组 {
    public int[] shuffle(int[] nums, int n) {
        int[] temp = new int[n];
        for (int i = 0; i < n; i++){
            temp[i] = nums[i];
        }
        for (int i = 0; i < 2 * n; i++){
            if (i % 2 == 0){
                nums[i] = temp[i / 2];
            }else {
                nums[i] = nums[n + i / 2];
            }
        }
        return nums;
    }
    // 为保证空间复杂度为O(1) 我们需要进行原地标记交换。
    public int[] shuffle1(int[] nums, int n) {
        for (int i = 0; i < 2 * n; i++){
            int j = i;
            while (nums[i] > 0) {
                j = j < n ? j * 2 : 2 * (j - n) + 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = -temp;
            }
        }
        for (int item:nums){
            item = -item;
        }
        return nums;
    }
}
