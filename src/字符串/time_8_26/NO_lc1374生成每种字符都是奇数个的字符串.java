package 字符串.time_8_26;

/**lc1374生成每种字符都是奇数个的字符串
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/26 12:51
 */
public class NO_lc1374生成每种字符都是奇数个的字符串 {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++)
                sb.append('a');
            sb.append('b');
        } else {
            for (int i = 0; i < n; i++)
                sb.append('a');
        }
        return sb.toString();
    }
}
