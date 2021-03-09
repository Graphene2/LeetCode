package binarySearch;

/**
 * Description:lc300题，给定一个无序的整数数组，找到其中最长上升子序列的长度。难度较大，状态的定义不好理解
 * User: zhangcheng
 * Date: 2020-10-16
 * Time: 9:17-10:24
 */
public class lc300最长上升子序列 {
    // 动态规划，dp[i]为以nums[i]为最后一个元素的最长子序列的长度，必须以nums[i]结尾。
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            maxans = Math.max(dp[i],maxans);
        }
        return maxans;
    }
    // 贪心 + 二分查找
    // 我们让上升子序列上升的尽可能慢，让每次子序列最后加上那个数尽可能小。
    // 维护dp[i] 表示长度为i的最长上升子序列的末尾元素的最小值，len记录目前最长上升子序列的长度。
    // dp[i] 是关于i单调递增的。
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        // dp数组的定义：长度为i+1的最长子序列末尾数字是几
        int[] dp = new  int[len];
        // 初始状态，遍历第一个数吧nums[0] 放在开头
        dp[0] = nums[0];
        // end为数组的最后一个位置，即dp的长度-1;
        int end = 0;
        for (int i = 1; i < len; i++) {
            int left = 0;
            int right = end + 1;
            while (left < right){
                int mid = (left + right) / 2;
                if (nums[i] > dp[mid]){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            dp[left] = nums[i];
            if (left == end + 1){
                end++;
            }
        }
        end++;
        return end;
    }
}
