package 字符串.time_8_27;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 14:30-14:47
 */
public class YES_lc1422分割字符串的最大得分 {
    public int maxScore(String s) {
        int ans = 0,cnt1 = 0, cnt0 = 0;
        for (int i = 0; i < s.length(); i++){
            cnt1 += s.charAt(i) - '0';
        }
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == '0') cnt0++;
            else cnt1--;
            ans = Math.max(ans, cnt0 + cnt1);
        }
        return ans;
    }
}
