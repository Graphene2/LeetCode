package traceback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description:方法:回溯方法！
 * User: zhangcheng
 * Date: 2020-10-19
 * Time: 21:24
 */
public class lc77组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        traceback(n,k,1,path,res);
        return res;
    }

    private void traceback(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 下一轮搜索i <= n - (k - path.size()) + 1 剪枝方法！
        for (int i = begin; i <= n ; i++) {
            path.add(i);
            traceback(n,k,i+1,path,res);
            path.removeLast();
        }

    }
}
