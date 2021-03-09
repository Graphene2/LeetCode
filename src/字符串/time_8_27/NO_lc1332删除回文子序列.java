package 字符串.time_8_27;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/27,23:05
 * @version: 1.0
 */
public class NO_lc1332删除回文子序列 {
    public int removePalindromeSub(String s) {
        if ("".equals(s)) return 0;
        if (s.equals(new StringBuilder(s).reverse().toString())) return 1;
        return 2;
    }
}
