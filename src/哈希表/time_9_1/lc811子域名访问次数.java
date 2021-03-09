package 哈希表.time_9_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/1 15:11
 */
class lc811子域名访问次数 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++){
            String[] str = cpdomains[i].split(" ");
            int len = Integer.valueOf(str[0]);
            String[] str2 = str[1].split("\\.");
            int len2 = str2.length;
            String str3 = "";
            for (int j = len2 - 1; j >= 0; j--){
                if (j == len2 - 1){
                    str3 = str2[j];
                }else {
                    str3 = str2[j]+"."+str3;
                }
                map.put(str3,map.getOrDefault(str3,0)+len);
            }
        }
        for (String key:map.keySet()){
            String str = "";
            str = map.get(key) + " " + key;
            result.add(str);
        }
        return result;
    }
}
