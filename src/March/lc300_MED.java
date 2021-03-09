package March;

import java.util.Arrays;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-04
 * Time: 14:23
 */
public class lc300_MED {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp,1);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return len;
        }
        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;

        for (int i = 1; i < len; i++) {
            if (nums[i] > tail[end]){
                end++;
                tail[end] = nums[i];
            }else {
                int left = 0,right = end;
                while (left < right){
                    int mid = (left + right) / 2;
                    if (tail[mid] < nums[i]){
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        end++;
        return end;
    }
}
