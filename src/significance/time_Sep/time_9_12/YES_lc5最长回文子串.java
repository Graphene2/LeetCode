package significance.time_Sep.time_9_12;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/12 15:30
 */
public class YES_lc5最长回文子串 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int ans = 0;
        String str = "";
        for (int i = 0; i < 2 * n - 1; i++){
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                int temp = r - l + 1;
                if (temp > ans){
                ans = temp;
                str = s.substring(l,r + 1);
                }
                l--;r++;
            }
        }
        return str;
    }
}
