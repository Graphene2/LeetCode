package 字符串.time_8_24;

/**lc58最后一个单词的长度
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/24 9:15-9:34
 */
public class NO_lc58最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >=0; i--){
            if (s.charAt(i) != ' '){
                count++;
            }
            if (count != 0 && s.charAt(i) == ' '){
                break;
            }
        }
        return count;
    }
}
