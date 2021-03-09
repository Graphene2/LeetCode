package 字符串.time_8_26;

/**lc459重复的子字符串
 * 思路：两倍字符串，去掉头尾后判断是否有该子串
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/26,10:37
 * @version: 1.0
 */
public class YES_lc459重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1,str.length() - 1).contains(s);
    }
}
