package 字符串.time_8_24;

/**lc709转换为小写字母
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/24 9:45-10:11
 */
public class lc709转换为小写字母 {
        public String toLowerCase(String str) {
            if (str == null || str.length() == 0) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            for (char cc: str.toCharArray()){
                if (cc >= 'A' && cc <= 'Z'){
                    sb.append((char)(cc + 32));
                }else {
                    sb.append(cc);
                }
            }return sb.toString();
        }
}
