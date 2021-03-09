package DP;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-25
 * Time: 11:29
 */
public class lc213打家窃舍II {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return nums[0];
        }
        if (len == 2){
            return Math.max(nums[0],Math.max(nums[1],nums[2]));
        }
        int pre = nums[1], curr = Math.max(nums[1],nums[2]);

        for (int i = 3; i < len; i++) {
            int temp = curr;
            curr = Math.max(pre + nums[i],curr);
            pre = temp;
        }
        int max = curr;
        curr = Math.max(nums[0],nums[1]);
        pre = nums[0];
        for (int i = 2; i < len - 1; i++) {
            int temp = curr;
            curr = Math.max(pre + nums[i],curr);
            pre = temp;
        }
        return Math.max(max,curr);
    }
}
