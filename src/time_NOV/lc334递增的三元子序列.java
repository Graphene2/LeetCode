package time_NOV;

import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-10
 * Time: 20:50-21:15
 */
public class lc334递增的三元子序列 {
    // 时间O(n2) 空间 O(n) 采用dp的方法 dp表示在i之前比他小的数的个数
    public boolean increasingTriplet(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                if (dp[i] >= 3) return true;
            }
        }
        return false;
    }
    public boolean increasingTriplet2(int[] nums) {
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int a:nums){
            if (min >= a){
                min = a;
            }else if (mid >= a){
                mid = a;
            }else {
                return true;
            }
        }
        return false;
    }
    // 保留两个数组，分别存放从前往后最小元素和从后往前最大元素
    public boolean increasingTriplet3(int[] nums) {
        if (nums.length < 3){
            return false;
        }
        int[] minVec = new int[nums.length];
        minVec[0] = nums[0];
        int[] maxVec = new int[nums.length];
        maxVec[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
           minVec[i] = Math.min(minVec[i - 1],nums[i]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            maxVec[i] = Math.max(maxVec[i + 1],nums[i]);
        }
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] > minVec[i] && nums[i] < maxVec[i]){
                return true;
            }
        }
        return false;
    }
}
