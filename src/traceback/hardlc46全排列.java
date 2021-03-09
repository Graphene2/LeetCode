package traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-06
 * Time: 19:18
 */
public class hardlc46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return ans;
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        backtrace(nums,path,used,0,len,ans);
        return ans;
    }

    private void backtrace(int[] nums, List<Integer> path, boolean[] used, int depth, int len, List<List<Integer>> ans) {
        if (depth == len){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backtrace(nums,path,used,depth+1,len,ans);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return res;
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        backtrace2(nums,path,used,0,len,res);
        return res;
    }

    private void backtrace2(int[] nums, List<Integer> path, boolean[] used, int depth, int len,
                            List<List<Integer>> res) {
        // 终止条件
        if (depth == nums.length){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backtrace2(nums,path,used,depth + 1,len,res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
