package 字符串.time_8_24;

/**lc917仅仅反转字母
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/24 10:11-10:26
 */
public class NO_lc917仅仅反转字母 {
    public String reverseOnlyLetters(String S) {
        if (S.length() == 0 || S == null) throw new RuntimeException();
        char[] aa = S.toCharArray();
        int i = 0, j = aa.length - 1;
        while (i < j){
            if (isChar(aa[i]) && isChar(aa[j])){
                char temp = aa[j];
                aa[j] = aa[i];
                aa[i] = temp;
                i++;
                j--;
            }else if (!isChar(aa[j])){
                j--;
            }else if (!isChar(aa[i])){
                i++;
            }
        }return new String(aa);
    }
    // 已经有函数isLetter.
    public boolean isChar(char a){
        if (a >= 'A' && a <= 'Z' || a >= 'a' && a <= 'z'){
            return true;
        }else return false;
    }
}
