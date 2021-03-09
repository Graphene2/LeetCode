package 哈希表.time_8_29;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/29,14:19-14:28
 * @version: 1.0
 */
public class NO_lc1207独一无二的出现次数 {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        int start = 0, i = 0;
        while (i < arr.length){
            while (arr[i] == arr[start] && i < arr.length){
                i++;
            }
            if (set.contains(i - start)){
                return false;
            }else {
                set.add(i - start);
            }
            start = i;
        }
        return true;
    }
}
