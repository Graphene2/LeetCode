package 字符串.time_8_27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 15:36
 */
public class YES_lc893特殊等价字符串组 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String ss: A){
            int[] count = new int[52];
            for (int i = 0; i < ss.length(); i++){
                count[ss.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            set.add(String.valueOf(count));
        }
        return set.size();
    }
}
