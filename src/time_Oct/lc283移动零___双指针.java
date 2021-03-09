package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 17:05
 */
public class lc283移动零___双指针 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int fast = 0,slow = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                if (nums[fast] != nums[slow]){
                    nums[slow] = nums[fast];
                    slow++;
                }
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++){
            nums[i] = 0;
        }
        return;
    }
}
