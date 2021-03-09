package 字符串.time_8_25;

/**lc521最长特殊子序列
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/25 8:51-9:06
 */
public class NO_lc521最长特殊子序列 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
}
