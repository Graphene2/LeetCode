package 哈希表.time_8_29;

import java.util.HashMap;
import java.util.Map;

/**时间复杂度为O(M*N) 即为words中字符总长度。 还可以优化！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,22:16-10:12
 * @version: 1.0
 */
public class NO_lc953验证外星语词典 {
    public boolean isAlienSorted(String[] words, String order) {
        int m = order.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++){
            map.put(order.charAt(i),i);
        }
        for(int i = 0; i < words.length - 1; i++){
            int j = 0;
            while (j < words[i].length() || j < words[i + 1].length()){
                int m1 = j < words[i].length() ? map.get(words[i].charAt(j)) : -1;
                int m2 = j < words[j].length() ? map.get(words[i + 1].charAt(j)) : -1;
                if (m1 > m2) break;
                else if (m1 == m2) {
                    j++;
                    continue;
                }else if (m1 < m2){
                    return false;
                }
            }
        }
        return true;
    }
}
