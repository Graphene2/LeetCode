package traceback;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-22
 * Time: 18:18
 */
public class lc139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // dp[i]状态定义为以i结尾的字符串或者其所有子串是否在字典中。
        Set<String> set = new HashSet<>();
        for(String str:wordDict){
            set.add(str);
        }
        boolean[] dp = new boolean[len];
        for (int r = 0; r < len; r++) {
            if (set.contains(s.substring(0, r + 1))){
                dp[r] = true;
                continue;
            }
            for (int l = 0; l < r; l++) {
                if (dp[l] && set.contains(s.substring(l + 1, r + 1))){
                    dp[r] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}
