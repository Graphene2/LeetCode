package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-06
 * Time: 18:38-19:16
 */
public class lc40组合总数II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int len = candidates.length;
        if (len == 0){
            return ans;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backtrace(path,candidates,len,0,target,ans);
        return ans;
    }

    private void backtrace(List<Integer> path, int[] candidates, int len, int begin, int target, List<List<Integer>> ans) {
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++){
            if (target - candidates[i] < 0){
                break;
            }
            if (i > begin && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            backtrace(path,candidates,len,i+1,target - candidates[i],ans);
            path.remove(path.size()-1);
        }
    }
}
