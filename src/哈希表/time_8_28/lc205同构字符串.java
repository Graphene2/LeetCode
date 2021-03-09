package 哈希表.time_8_28;

import java.util.HashMap;
import java.util.Map;

/** 需要对应转换两次，题目首先还是要读懂。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,21:23-22:05
 * @version: 1.0
 */
public class lc205同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0; i < ss.length; i++){
            if (map.containsKey(ss[i])){
                if (map.get(ss[i]) != tt[i]){
                    return false;
                }
            }else {
                map.put(ss[i],tt[i]);
            }
        }
        return true;
    }

    // 将两组字符串全部映射到第三方逻辑机构，然后对比两个第三方机构是否相同。
    public boolean isIsomorphic2(String s, String t) {
        return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
    }

    private String isIsomorphicHelper(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当前字母第一次出现,赋值
            if (map[c] == 0) {
                map[c] = count;
                count++;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }



}
