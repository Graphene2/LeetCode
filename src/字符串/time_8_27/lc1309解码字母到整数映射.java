package 字符串.time_8_27;


import java.util.HashMap;
import java.util.Map;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/27,19:28-19:56
 * @version: 1.0
 */
public class lc1309解码字母到整数映射 {
    public String freqAlphabets(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (i + 2 < s.length() && s.charAt(i + 2) == '#'){
                int tmp = Integer.valueOf(s.substring(i,i+2))  + 'a';
                ans.append((char) (tmp - 1));
                i += 2;
            }else {
                ans.append((char)((s.charAt(i) - '1') + 'a'));
            }
        }return ans.toString();
    }
}
