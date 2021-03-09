package traceback;

import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-22
 * Time: 15:27-16:15
 */
public class lc140单词拆分II {
    // 超时了orz，主要原因是采用了暴力回溯方法，时间复杂度高达n的n次方。
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) return res;
        List<String> path = new ArrayList<>();
        traceback(s,wordDict,0,res,path);
        return res;
    }

    private void traceback(String s, List<String> wordDict, int begin, List<String> res, List<String> path) {
        // begin 为下一段的其实位置，只有该端存在字典中才进行下一段的深入，用一个for表示同一层的遍历尝试，剪枝通过判断实现
        // 终止条件，begin到达队列末尾。
        if (begin == s.length()){
            res.add(String.join(" ",path));
        }
        for (int i = begin; i < s.length(); i++) {
            String sub = s.substring(begin,i + 1);
            if (isExit(wordDict,sub)){
                path.add(sub);
                traceback(s,wordDict, i + 1,res,path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isExit(List<String> wordDict, String str) {
        for (int i = 0; i < wordDict.size(); i++) {
            if (str.equals(wordDict.get(i))){
                return true;
            }
        }
        return false;
    }
    //
    public List<String> wordBreak2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        return word_Break(s, wordSet, 0);
    }
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                // 保存以start位置开头的后续所有可能的String，然后把所有可能存放到list中，通过递归从最后往前填充map。
                // 而res每次都要从后往前更新，所以最后更新到其实位置递归结束。全过程也就是递归到底存下来，然后逐层上升回到顶部，顶部即为答案。
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }
    public List<String> word_Break2(String s, Set<String> wordDict, int start){
        if (map.containsKey(start)){
            return map .get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()){
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start,end))){
                List<String> list = word_Break2(s,wordDict,end);
                for (String l:list){
                    res.add(s.substring(start,end) + (l.equals("")?"" :" ") + l);
                }
            }
        }
        map.put(start,res);
        return res;
    }
    // 动态规划进行保存
    public List<String> wordBreak4(String s, List<String> wordDict) {
        int len = s.length();
        // 状态定义：以 s[i] 结尾的子字符串是否符合题意
        boolean[] dp = new boolean[len];
        // 预处理
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        // 动态规划问题一般都有起点，起点也相对好判断一些
        // dp[0] = wordSet.contains(s.charAt(0));
        for (int r = 0; r < len; r++) {
            if (wordSet.contains(s.substring(0, r + 1))) {
                dp[r] = true;
                continue;
            }
            for (int l = 0; l < r; l++) {
                // dp[l] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if (dp[l] && wordSet.contains(s.substring(l + 1, r + 1)) ) {
                    dp[r] = true;
                    // 这个 break 很重要，一旦得到 dp[r] = True ，循环不必再继续
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (dp[len - 1]) {
            LinkedList<String> queue = new LinkedList<>();
            dfs(s, len - 1, wordSet, res, queue, dp);
            return res;
        }

        return res;
}

    private void dfs(String s, int end, Set<String> wordSet, List<String> res, LinkedList<String> queue, boolean[] dp) {
        // 先添加0-end的最后一段
        if (wordSet.contains(s.substring(0, end + 1))) {
            queue.addFirst(s.substring(0, end + 1));

            StringBuilder stringBuilder = new StringBuilder();
            for (String word : queue) {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
            // 删除掉sb最后的“ ”
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            // 添加数组到结果队列，完毕。
            res.add(stringBuilder.toString());
            //
            queue.removeFirst();
        }
        // 没有到最后关头，开始尝试中间部分，进行树的同层次遍历。
        for (int i = 0; i < end; i++) {
            // 判断两个true的中间部分是否在字典中，如果在的话那就遍历下去。
            if (dp[i]) {
                String suffix = s.substring(i + 1, end + 1);

                if (wordSet.contains(suffix)) {
                    queue.addFirst(suffix);
                    dfs(s, i, wordSet, res, queue, dp);
                    queue.removeFirst();
                }
            }

        }

    }
    private void dfs2(String s, int end, Set<String> wordSet, List<String> res, LinkedList<String> queue, boolean[] dp) {
        if (wordSet.contains(s.substring(0,end + 1))){
            queue.addFirst(s.substring(0,end + 1));
            StringBuilder sb = new StringBuilder();
            for (String str:queue){
                sb.append(str + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            queue.removeFirst();
        }
        for (int i = 0; i < end; i++) {
            if (dp[i]){
                String substr = s.substring(i + 1,end + 1);
                if (wordSet.contains(substr)){
                    queue.addFirst(substr);
                    dfs2(s,i,wordSet,res,queue,dp);
                    queue.removeFirst();
                }
            }
        }
    }
}
