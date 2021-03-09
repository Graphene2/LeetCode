package 哈希表.time_8_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/30,15:41
 * @version: 1.0
 */
public class YES_lc599两个列表的最小索引总和 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int minSum = Integer.MAX_VALUE, sum = 0;
        Map<String, Integer> map = new HashMap<>();
        List< String > res = new ArrayList< >();
        for (int i = 0; i < list1.length; i++){
            map.put(list1[i],i);
        }
        for (int i = 0; i < list2.length; i++){
            if (map.containsKey(list2[i])){
                sum = i + map.get(list2[i]);
                if (sum < minSum){
                    res.clear();
                    res.add(list2[i]);
                    minSum = sum;
                }else if (minSum == sum){
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
