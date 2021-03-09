package DP;

/**
 * Description:1. 第一遍完成。
 * User: zhangcheng
 * Date: 2020-11-25
 * Time: 15:37
 */
public class 面试17_16按摩师 {
    public int massage(int[] nums) {
        // 典型的dp问题
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return nums[0];
        }
        // dp表示为当前最大预约时间
        int pre = nums[0];
        int cur = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            int tmp = cur;
            cur = Math.max(nums[i] + pre, cur);
            pre = tmp;
        }
        return cur;
    }
}
