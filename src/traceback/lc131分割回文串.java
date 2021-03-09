package traceback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-22
 * Time: 10:41-10:52
 */
public class lc131分割回文串 {
    public List<List<String>> partition(String s){
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) return res;
        Deque<String> path = new ArrayDeque<>();
        traceback(s,0,len,res,path);
        return res;
    }

    private void traceback(String s, int start, int len, List<List<String>> res, Deque<String> path) {
        if (start == len){
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < len; i++) {
            // 同层剪枝
            if (!isPalindrome(s,start,i)){
                continue;
            }
            path.addLast(s.substring(start,i + 1));
            traceback(s,i + 1,len,res,path);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    // 采用动态规划预处理回文串！
    public List<List<String>> partition2(String s){
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, dp, stack, res);
        return res;
    }

    private void backtracking(String s, int start, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            // 剪枝
            if (!dp[start][i]) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, dp, path, res);
            path.removeLast();
        }
    }
    // 用中心法进行预处理，更快！
    public List<List<String>> partition3(String s){
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int i = 0; i < len; i++) {
            prePro(s,i,i,dp);
            prePro(s,i,i + 1,dp);
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, dp, stack, res);
        return res;
    }

    private void prePro(String s, int left, int right, boolean[][] dp) {
        while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)){
            dp[left][right] = true;
            left++;
            right--;
        }
    }

}
