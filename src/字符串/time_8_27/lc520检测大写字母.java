package 字符串.time_8_27;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 16:08
 */
public class lc520检测大写字母 {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            char s = word.charAt(i);
            if (s >= 'A' && s <= 'Z'){
                count++;
            }
        }
        if (count == 0 || count == word.length() || (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')){
            return true;
        }else
            return false;
    }
}

