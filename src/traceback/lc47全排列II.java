package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-06
 * Time: 21:21
 */
public class lc47全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0) return ans;

        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        backtrace(nums, len, 0, used, path, ans);
        return ans;
    }

    private void backtrace(int[] nums, int len, int depth, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        if (depth == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrace(nums, len, depth + 1, used, path, ans);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
