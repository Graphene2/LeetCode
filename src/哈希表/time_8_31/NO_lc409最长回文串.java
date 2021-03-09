package 哈希表.time_8_31;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/31,10:42-11:06
 * @version: 1.0
 */
public class NO_lc409最长回文串 {
    public static int longestPalindrome(String s) {
        int ans = 0, flag = 0;
        int[] arr = new int[58];
        for (int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'A']++;
        }
        for (int i:arr){
            if (i % 2 == 0){
                ans += i - (i & 1);
            }else {
                flag = 1;
            }
        }
        return ans + flag;
    }


}
