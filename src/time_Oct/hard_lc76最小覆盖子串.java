package time_Oct;

import jdk.jshell.EvalException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-28
 * Time: 20:28-20:58
 */
public class hard_lc76最小覆盖子串 {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
    public String minWindow(String s, String t) {
        int tLen = t.length();
        // 将目标子串存放到ori哈希表中
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0) + 1);
        }
        // 设置滑动窗口的左右指针
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        // 先进行的操作是移动右指针，当满足包含所以的字符串的时候再移动左指针。
        while (r < sLen){
            ++r;
            char ch = s.charAt(r);
            if (r < sLen && ori.containsKey(ch)){
                cnt.put(ch, cnt.getOrDefault(ch,0) + 1);
            }
            // 如果包含t，判断当前长度是否需要记录。
            while (check() && l <= r){
                if (r - l + 1 < len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                // 如果已包含，那么开始滑动左指针。
                char cc = s.charAt(l);
                if (ori.containsKey(cc)){
                    cnt.put(cc,cnt.getOrDefault(cc,0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL,ansR);
    }
    // 判断当前cnt哈希表中的字母和目标数组中的字母，如果cnt全包含，则返回true
    private boolean check() {
        for (Character cc : ori.keySet()){
            if (cnt.getOrDefault(cc,0) < ori.get(cc)){
                return false;
            }
        }
        return true;
    }
}
