package 哈希表.time_9_1;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/1 9:07:9:19-9:28
 */
class NO_lc290单词规律 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int pos1 = 0;
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if (!map1.containsKey(c)){
                map1.put(c,pos1);
                sb1.append(pos1);
                pos1++;
            }else {
                sb1.append(map1.get(c));
            }
        }
        int pos2 = 0;
        StringBuilder sb2 = new StringBuilder();
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++){
            String newS = arr[i];
            if (!map2.containsKey(newS)){
                map2.put(newS,pos2);
                sb2.append(pos2);
                pos2++;
            }else {
                sb2.append(map2.get(newS));
            }

        }
        return sb1.toString().equals(sb2.toString());
    }
}
