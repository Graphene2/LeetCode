package 字符串.time_8_24;

/**lc557反转字符串中的单词III
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/24,19:39
 * @version: 1.0
 */
public class lc557反转字符串中的单词III {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int start = -1, end = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                end = i - 1;
                while (end > start){
                    sb.append(s.charAt(end--));
                }
                sb.append(' ');
                start = i;
            }else if (i == s.length() - 1){
                end = i;
                while (end > start){
                    sb.append(s.charAt(end--));
                }
            }
        }return sb.toString();
    }
}
