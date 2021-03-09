package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-14
 * Time: 14:09-14:16
 */
public class lc55跳跃游戏 {
    public boolean canJump(int[] nums){
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (rightMost >= n - 1) return true;
            if (i > rightMost) return false;
            rightMost = Math.max(rightMost, i + nums[i]);
        }
        return true;
    }
}
