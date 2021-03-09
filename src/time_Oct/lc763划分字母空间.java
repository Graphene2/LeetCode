package time_Oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-22
 * Time: 9:31-9:57
 */
public class lc763划分字母空间 {
    public List<Integer> partitionLabels(String S) {
        Map<Character,Integer> map = new HashMap<>();
        char[] ch = S.toCharArray();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            map.put(ch[i],i);
        }
        int maxPos = 0;
        while (maxPos < ch.length){
            int start = maxPos + 1;
            if (maxPos == 0){
                start--;
            }
            maxPos = map.get(ch[start]);
            for (int i = start; i <= maxPos; i++){
                maxPos = Math.max(maxPos, map.get(ch[i]));
            }
            res.add(maxPos - start + 1);
        }
        return res;
    }
    // 优化: 1.直接采用两个变量分别记录当前字母的end和最大的end，在指针到达最大的end时记录长度。

    public List<Integer> partitionLabels2(String S){
        int[] last = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end,last[S.charAt(i) - 'a']);
            if (i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
