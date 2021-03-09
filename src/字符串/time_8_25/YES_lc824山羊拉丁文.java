package 字符串.time_8_25;

import java.util.HashSet;
import java.util.Set;

/**lc824山羊拉丁文
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/25 9:24
 */
public class YES_lc824山羊拉丁文 {
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<>();
        for (char c: new char[]{'a','e','i','o','u','A','E','I','O','U'})
            vowel.add(c);

        int t = 1;
        StringBuilder sb = new StringBuilder();
        for (String word: S.split(" ")){
            char first = word.charAt(0);
            if (vowel.contains(first)){
                sb.append(word);
            }else {
                sb.append(word.substring(1));
                sb.append(word.substring(0,1));
            }
            sb.append("ma");
            for (int i = 0; i < t; i++){
                sb.append('a');
            }
            t++;
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}


