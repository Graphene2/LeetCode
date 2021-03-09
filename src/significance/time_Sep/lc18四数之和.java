package significance.time_Sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-21
 * Time: 15:11
 */
public class lc18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4) return ans;
        Arrays.sort(nums);
        if (target < nums[0] + nums[1] + nums[2] + nums[3]
                || target > nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4]) {
            return ans;
        }
        int a,b,c,d;
        for (a = 0; a <= len - 4; a++){
            if (a > 0 && nums[a] == nums[a - 1]){
                continue;
            }
            for (b = a + 1; b <= len - 3; b++){
                if (b > a + 1 && nums[b] == nums[b - 1]){
                    continue;
                }
                c = b + 1;
                d = len - 1;
                while (c < d){
                    if (nums[a] + nums[b] + nums[c] + nums[d] < target){
                        c++;
                    }else if (nums[a] + nums[b] + nums[c] + nums[d] > target){
                        d--;
                    }else {
                        ans.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        while (c < d && nums[c] == nums[c + 1]) c++;
                        while (c < d && nums[d] == nums[d - 1]) d--;
                        c++;d--;
                    }
                }
            }
        }
        return ans;
    }
}
