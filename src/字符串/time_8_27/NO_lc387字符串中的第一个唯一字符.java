package 字符串.time_8_27;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/27,22:17-22:28
 * @version: 1.0
 */
public class NO_lc387字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0;i < s.length(); i++){
            if (arr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
