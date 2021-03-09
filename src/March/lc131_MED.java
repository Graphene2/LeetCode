package March;

import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-07
 * Time: 13:15
 */
public class lc131_MED {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        Deque<String> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        dfs(chars,0,len,stack,res);
        return res;
    }

    private void dfs(char[] chars, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if (!checkPalindrome(chars,index,i)){
                continue;
            }
            path.addLast(new String(chars,index + 1,i + 1 - index));
            dfs(chars,i + 1, len, path,res);
            path.removeLast();
        }
    }

    private boolean checkPalindrome(char[] chars, int left, int right) {
        while (left < right){
            if (chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // 方法二，使用动态规划判断所有子串是否是回文的。
    public List<List<String>> partition2(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right ; left++) {
                if (chars[left] == chars[right] && (right - left <= 2 || dp[left + 1][right - 1])){
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        DFS(s,0,len,dp,stack,res);
        return res;
    }

    private void DFS(String s, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (index == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if (dp[index][i]){
                path.addLast(s.substring(index,i + 1));
                DFS(s,i + 1,len,dp,path,res);
                path.removeLast();
            }
        }
    }
}
