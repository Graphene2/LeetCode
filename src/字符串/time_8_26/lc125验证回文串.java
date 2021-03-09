package 字符串.time_8_26;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/26 16:43
 */
public class lc125验证回文串 {
    public boolean isPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0 || s == null) return true;
        int start = 0, end = s.length() - 1;
        while (start < end){
            if (!Character.isLetterOrDigit(s.charAt(start))){
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))){
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end)))   {
                start++;
                end--;
            }else return false;
        }
        return true;
    }
}
