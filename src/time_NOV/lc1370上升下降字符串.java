package time_NOV;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-25
 * Time: 8:32
 */
public class lc1370上升下降字符串 {
    public String sortString(String s) {
        int[] bottom = new int[26];
        int len = s.length();
        for (char c:s.toCharArray()) {
            bottom[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        while (len > 0){
            for (int i = 0; i < 26; i++) {
                if (bottom[i] > 0){
                    res.append((char) ('a' + i));
                    bottom[i]--;
                    len--;
                }
            }
            for (int i = 25; i >= 0 ; i--) {
                if (bottom[i] > 0){
                    res.append((char) ('a' + i));
                    bottom[i]--;
                    len--;
                }
            }
        }
        return res.toString();
    }
}
