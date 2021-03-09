package 字符串.time_8_27;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 13:15
 */
public class YES_lc680验证回文字符串II {
    public boolean validPalindrome(String s) {
        // 碰到第一次不同时分两种情况讨论。
        int low = 0, high = s.length() - 1;
        while (low < high ){
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2){
                low++;high--;
            }else {
                boolean flag1 = true, flag2 = true;
                for (int i = low,j = high - 1; i < j; i++,j--){
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4){
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--){
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4){
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

}
