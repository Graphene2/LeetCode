package JAVAFORMEETING;

import java.util.Arrays;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-04-15
 * Time: 10:59
 */
public class lc213打家劫舍II {
    // dp[i]表示前i个房子能够窃取到的最大的金额
    public int rob(int[] nums){
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];

        return Math.max(myRob(Arrays.copyOfRange(nums,0,len - 1)),
                myRob(Arrays.copyOfRange(nums,1,len)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
