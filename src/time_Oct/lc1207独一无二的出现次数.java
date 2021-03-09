package time_Oct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-28
 * Time: 8:41-8:52
 */
public class lc1207独一无二的出现次数 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int a : map.values()){
            if (seen.contains(a)){
                return false;
            }
            seen.add(a);
        }

//        for (Map.Entry<Integer,Integer> entry:map.entrySet())
//            if (!seen.contains(entry.getValue()))
//                seen.add(entry.getValue());
//            else return false;

        return true;
    }
}
