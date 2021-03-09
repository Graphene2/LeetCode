package 哈希表.time_8_31;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/31 18:21
 */
public class NO_lc242有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (char e:s.toCharArray()){
            arr[e - 'a']++;
        }
        for (char e:t.toCharArray()){
            arr[e - 'a']--;
            if (arr[e - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
