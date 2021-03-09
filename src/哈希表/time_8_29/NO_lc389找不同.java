package 哈希表.time_8_29;

/**字母异或直接找不同！大佬牛逼！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/29,10:13-10:23
 * @version: 1.0
 */
public class NO_lc389找不同 {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for (char e:t.toCharArray()){
            arr[e - 'a']++;
        }
        for (char e:s.toCharArray()){
            arr[e - 'a']--;
        }
        for (int i = 0 ; i < 26; i++){
            if (arr[i] == 1){
                return (char)(i + 'a');
            }
        }
        return ' ';
    }
    // 直接通过异或的方式找不同！
    public char findTheDifference2(String s, String t) {
        char ans = 0;
        for (int i = 0; i < s.length(); i++){
            ans ^= s.charAt(i) ^ t.charAt(i);
        }
        ans ^= t.charAt(t.length() - 1);
        return ans;
    }

}
