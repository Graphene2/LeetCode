package traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-20
 * Time: 8:54-9:22
 */
public class lc78子集 {
    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }

    private void dfs(int i, int[] nums) {
        // 终止条件。
        if (i == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        // 有点像前序遍历，先添加根节点，在进行叶子结点遍历
        tmp.add(nums[i]);
        dfs(i+1,nums);
        // 需要回溯，所以必须删除当前添加的节点。即判断选择当前节点或者不选择当前节点
        tmp.remove(tmp.size()-1);
        dfs(i+1,nums);
    }
    // 方法二:一个终极简单的方法，用一个二进制数判断当前位置选还是不选。
    public List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) tmp.add(nums[j]);
            }
            res.add(tmp);
        }
        return res;
    }
    // 常规枚举
    public static void subsets3(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length) return;
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> newSub = new ArrayList<Integer>(res.get(j));
            newSub.add(nums[i]);
            res.add(newSub);
        }
        subsets3(nums, i + 1, res);
    }

}
