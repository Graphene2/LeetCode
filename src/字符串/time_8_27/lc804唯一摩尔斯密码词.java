package 字符串.time_8_27;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 10:38-10:51
 */
public class lc804唯一摩尔斯密码词 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        Set<String> seen = new HashSet();
        for (String word: words) {
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray())
                code.append(MORSE[c - 'a']);
            seen.add(code.toString());
        }
        return seen.size();
    }
}
