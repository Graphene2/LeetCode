package 字符串.time_8_27;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 10:05-10:38
 */
public class YES_lc13罗马数字转整数 {
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>(){
            {
            put('I',1);put('V',5);put('X',10);put('L',20);put('C',100);put('D',500);put('M',1000);
            }
        };
        int ans = 0;
        if (s.length() == 1) return map.get(s.charAt(0));
        for (int i = 0; i + 1 < s.length(); i++){
            if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                ans -= map.get(s.charAt(i));
            }else ans += map.get(s.charAt(i));
        }
        ans += map.get(s.charAt(s.length() - 1));
        return ans;
    }
}
