package traceback;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-21
 * Time: 14:21-15:50
 */
public class lc60第k个排列 {
    // 采用回溯的方法，但是效率不高，而且回溯方法要注意res和count如果不为全局变量的话值会改变！
    int count;
    String res = new String();
    public String getPermutation(int n, int k) {
        if (n == 1){
            return "1";
        }
        boolean[] used = new boolean[n + 1];

        boolean find = false;
        count = 0;
        dfs(n,k,1,"",false,used);
        return res;
    }

    private void dfs(int n, int k, int depth, String path, boolean find, boolean[] used) {
        if (find == true) return;
        if (depth == n + 1){
            count++;
            if (count == k){
                res = path;
                find = true;
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i]){
                used[i] = true;
                dfs(n,k,depth + 1,path + i,find,used);
                used[i] = false;
            }
        }
    }
    // 进行剪枝操作！！！

    private boolean[] used;
    private int[] factorial;

    private int n;
    private int k;

    public String getPermutation2(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFacterial(n);
        used = new boolean[n + 1];
        Arrays.fill(used,false);

        StringBuilder path = new StringBuilder();
        dfs2(0,path);
        return path.toString();

    }

    private void dfs2(int index, StringBuilder path) {
        if (index == n) return;
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n ; i++) {
            if (used[i]){
                continue;
            }
            if (cnt < k){
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs2(index + 1,path);
            return;
        }
    }

    private void calculateFacterial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n ; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    // 不用回溯采用循环！！！
    public String getPermutation3(int n,int k){
        final int[] arr = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        StringBuilder permutation = new StringBuilder();
        for (int i = n - 1; i >= 0 ; i--) {
            int cnt = arr[i];
            for (int j = 1; j <= n; j++){
                if (visited[j]){
                    continue;
                }
                if (k > cnt){
                    k -= cnt;
                    continue;
                }
                visited[j] = true;
                permutation.append(j);
                break;
            }
        }
        return permutation.toString();
    }
    public String getPermutation4(int n,int k){
        final int[] arr = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        k --;
        List<Integer> num = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        StringBuilder path = new StringBuilder();
        // i 表示剩余的数字个数，初始化为 n - 1,这里才是最强的，思考这里的i代表的两重意义！
        for (int i = n - 1; i >= 0 ; i--) {
            int index = k / arr[i];
            path.append(num.get(index));
            num.remove(index);
            k = k - index * arr[i];
        }
        return path.toString();
    }
}
