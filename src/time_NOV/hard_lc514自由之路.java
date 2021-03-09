package time_NOV;


import java.lang.reflect.Array;
import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-11
 * Time: 9:34-10:43
 */
public class hard_lc514自由之路 {
    String ring, key;
    List<Integer>[] pos;
    public int findRotateSteps(String ring, String key){
        this.ring = ring;
        this.key = key;
        pos = new List[26];
        for (int i = 0; i < ring.length(); i++) {
            int p = ring.charAt(i) - 'a';
            if (pos[p] == null) pos[p] = new ArrayList<>();
            pos[p].add(i);
        }
        return dfs(0,0);
    }
    // p1  在ring上的位置。其实是上一个的位置。
    // p2  在key上的位置。
    private int dfs(int p1, int p2) {
        if (p2 == key.length()) return 0;
        int p = key.charAt(p2) - 'a';
        int res = Integer.MAX_VALUE;
        for (int next: pos[p]) {
            int dist = Math.abs(next - p1);
            dist = Math.min(dist , ring.length() - dist);
            res = Math.min(res ,dist + dfs(next, p2 + 1) + 1);
        }
        return res;
    }
    Map<Integer, Map<Integer, Integer>> memo = new HashMap();
    public int findRotateSteps2(String ring, String key){
        this.ring = ring;   this.key = key;
        pos = new List[26];
        for (int i = 0; i < ring.length(); i++) {
            int p = ring.charAt(i) - 'a';
            if (pos[p] == null) pos[p] = new ArrayList<>();
            pos[p].add(i);
        }
        return dfs2(0,0);
    }

    private int dfs2(int p1, int p2) {
        if (p2 == key.length()) return 0;
        if (memo.containsKey(p1) && memo.get(p1).containsKey(p2)) return memo.get(p1).get(p2);
        int p = key.charAt(p2) - 'a';
        int res = Integer.MAX_VALUE;
        for (int next : pos[p]){
            int dist = Math.abs(next - p2);
            dist = Math.min(dist,ring.length() - dist);
            res = Math.min(res,dist +  dfs(next,p2 + 1));
        }
        memo.putIfAbsent(p1,new HashMap<>());
        memo.get(p1).get(p2);
        return res;
    }
    // 动态规划 dp[i][j] 表示从前往后拼出key的第i个字符，ring的第j个字符与12点钟方向对齐的最小步数。
    public int findRotateSteps3(String ring, String key){
        int m = key.length(), n = ring.length();
        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < n; i++) {
            int p = ring.charAt(i) - 'a';
            if (pos[p] == null) pos[p] = new ArrayList<>();
            pos[p].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        // key 上面的第0个字符在ring上的位置集合，dp[0][i] 就匹配表示key上的第0个字符最小距离
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; ++i) {
            // j 表示对应key上第i个字符在ring上的位置。ring上有重复的就会有不止一个j
            for (int j : pos[key.charAt(i) - 'a']) {
                // k 表示对应key上第i-1个字符在ring上的位置。
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
