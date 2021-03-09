package DEC;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-25
 * Time: 9:49
 */
public class lc128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)){
                int currentNum = num;
                int currentSreak = 1;
                while (set.contains(currentNum + 1)){
                    currentNum++;
                    currentSreak++;
                }
                longestStreak = Math.max(longestStreak,currentSreak);
            }
        }
        return longestStreak;
    }
}
