package time_NOV;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/11/22,10:38
 * @version: 1.0
 */
public class lc242有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] bottom = new int[26];
        for (char c:s.toCharArray()) {
            bottom[c - 'a']++;
        }
        for (char d:t.toCharArray()) {
            bottom[d - 'a']--;
            if (bottom[d - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
