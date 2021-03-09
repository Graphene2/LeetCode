package 字符串.time_8_26;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/26 15:26-15:40
 */
public class NO_lc1436旅行终点站 {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> str: paths){
            map.put(str.get(0),str.get(1));
        }
        String str = paths.get(0).get(0);
        while (map.containsKey(str)){
            str = map.get(str);
        }
        return str;
    }
}
