package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-20
 * Time: 9:38-10:17
 */
public class lc90子集II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        backtrace(nums,path,res,0);
        return res;
    }

    private void backtrace(int[] nums, List<Integer> path, List<List<Integer>> res, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            // 重点在这里，同层去重！
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrace(nums,path, res, i + 1);
            path.remove(path.size() - 1);
        }
    }

    //
}
