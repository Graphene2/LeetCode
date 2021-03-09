package time_NOV;

import java.util.Arrays;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-26
 * Time: 9:20
 */
public class hard_lc64最大间距 {
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return 0;
        }
        // 找出数组的最值，作为桶排序的两端分界。
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int bucketLen = Math.max(1 ,(maxVal - minVal) / (len - 1));
        int bucketSize = (maxVal - minVal) / bucketLen + 1;
        // 排除nums全部为一样的数字;
        if (maxVal - minVal == 0) return 0;
        //
        int[][] bucket = new int[bucketSize][2];
        //
        for (int i = 0; i < bucketSize; i++) {
            Arrays.fill(bucket[i],-1);
        }
        for (int i = 0; i < len; i++) {
            int pos = (nums[i] - minVal) / bucketLen;
            if (bucket[pos][0] == -1){
                bucket[pos][0] = bucket[pos][1] = nums[i];
            }else {
                bucket[pos][0] = Math.min(bucket[pos][0],nums[i]);
                bucket[pos][1] = Math.max(bucket[pos][1],nums[i]);
            }
        }
        // 遍历整个桶进行最大间隙的寻找。
        int maxGap = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1){
                continue;
            }
            if (prev != -1){
                maxGap = Math.max(maxGap,bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return maxGap;
    }


}
