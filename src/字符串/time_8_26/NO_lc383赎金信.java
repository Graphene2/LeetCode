package 字符串.time_8_26;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/26,21:29-21:36
 * @version: 1.0
 */
public class NO_lc383赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char e: magazine.toCharArray()){
            map.put(e, map.getOrDefault(e ,0) + 1);
        }
        for (char cc: ransomNote.toCharArray()){
            if (map.containsKey(cc) && map.get(cc) > 0){
                map.put(cc,map.get(cc) - 1);
            }else return false;
        }
        return true;
    }
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int caps[] = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1)
                return false;
            caps[c - 97] = index + 1;
        }
        return true;
    }
}
