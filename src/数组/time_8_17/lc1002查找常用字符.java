package 数组.time_8_17;

import java.util.ArrayList;
import java.util.List;

/**leetcode1002 查找常用字符 思路比较简单，主体是桶排序。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/17 9:06-9:32
 */
public class lc1002查找常用字符 {
    public List<String> commonChars(String[] A) {
        int[] temp = new int[26];
        int[] ans = new int[26];
        for(int i = 0; i < 26; i++){
            ans[i] = 100; }
        for (String ss: A){
            for (char cc:ss.toCharArray()){
                temp[cc - 'a']++;
            }
            for(int i = 0; i < 26; i++){
                ans[i] = Math.min(ans[i], temp[i]);
                temp[i] = 0;
            }

        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            while (ans[i] > 0){
                res.add(String.valueOf((char)(i + 'a')));
                ans[i]--;
            }
        }return res;
    }
}
