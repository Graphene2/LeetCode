package January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-14
 * Time: 14:35
 */
public class lc438找到字符串的所有字母异味词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pFre = new int[26];
        int pLen = p.length();
        int sLen = s.length();
        for (Character c : p.toCharArray()) {
            pFre[c - 'a']++;
        }
        int start = 0, end = -1;
        while (start < sLen){
            if (end + 1 < sLen && end - start + 1 < pLen){
                end++;
            }else {
                start++;
            }
            if (end - start + 1 == pLen && isMatch(s.substring(start,end + 1),pFre)){
                res.add(start);
            }
        }
        return res;
    }

    private boolean isMatch(String window, int[] pFreq) {
        int[] windowFreq = new int[26];
        for(int i = 0; i < window.length(); i++) {
            windowFreq[window.charAt(i)-'a']++;
        }
        for(int j = 0; j < 26; j++) {
            if (windowFreq[j] != pFreq[j]) {
                return false;
            }
        }
        return true;
    }
}
