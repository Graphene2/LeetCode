package 字符串.time_8_26;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/26,21:38-21:42
 * @version: 1.0
 */
public class NO_lc1221分割平衡字符串 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int Zero = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'L'){
                Zero++;
            }else if (s.charAt(i) == 'R'){
                Zero--;
            }
            if (Zero == 0){
                count++;
            }
        }
        return count;
    }
}
