package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-03
 * Time: 9:10
 */
public class lc560和为K的子数组 {
    // 1. 暴力方法
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right = 0;
        int count = 0;
        for (left = 0; left < len; left++) {
            int sum = 0;
            for (right = left; right < len; right++) {
                sum += nums[right];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }
    // 2. 前缀和 n ^ 2
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len ; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            for (int j = i; j >= 0; j--) {
                // 注意左右边界
                if (preSum[i + 1] - preSum[j] == k)
                    count++;
            }
        }
        return count;
    }
    // 3. 前缀和 + 哈希表 n
    public int subarraySum3(int[] nums, int k) {
        Map<Integer,Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);
        int len = nums.length;
        int count = 0;
        int preSum = 0;
        for (int i = 0; i < len; i++) {
            preSum += nums[i];
            if (preSumFreq.containsKey(preSum - k)){
                count += preSumFreq.get(preSum - k);
            }
            preSumFreq.put(preSum,preSumFreq.getOrDefault(preSum,0) + 1);
        }
        return count;
    }
}
