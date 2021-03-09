package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-06
 * Time: 18:13
 */
public class lc39组合总数 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(path,candidates,target,0,0);
        return ans;
    }

    private void backtrace(List<Integer> path, int[] candidates, int target, int sum, int begin) {
        if (target == sum){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++){
            int rs = candidates[i] + sum;
            if (rs <= target){
                path.add(candidates[i]);
                backtrace(path,candidates,target,rs,i+1);
                path.remove(path.size()-1);
            }else break;
        }
    }
}
