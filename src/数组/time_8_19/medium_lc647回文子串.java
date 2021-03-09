package 数组.time_8_19;

/**leetcode647:回文子串
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 9:02
 */
public class medium_lc647回文子串 {
    // 利用回文子串中心对称的特点。
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; i++){
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                ans++;
            }
        }return ans;
    }
}
