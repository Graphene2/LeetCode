package 字符串.time_8_24;

/**lc1556千位分隔数
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/24,22:26-20:40
 * @version: 1.0
 */
public class NO_lc1556千位分隔数 {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        int temp = n, i = 0;
        while(temp > 0){
            int m = temp % 10;
            temp = temp / 10;
            i++;
            sb.append(m);
            if (i % 3 == 0){
                sb.append('.');
            }
        }
        return sb.reverse().toString();
    }
}
