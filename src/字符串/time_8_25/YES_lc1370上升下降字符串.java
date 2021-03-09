package 字符串.time_8_25;

/**lc1370上升下降字符串
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/25 11:14
 */
public class YES_lc1370上升下降字符串 {
    public String sortString(String s) {
        int[] arr = new int[26];
        for (char aa:s.toCharArray()){
            arr[aa - 'a']++;
        }


        StringBuilder sb = new StringBuilder();
        while (haveChar(arr)){
            for (int i = 0; i < 26; i++){
                if (arr[i] > 0){
                    sb.append((char) (i + 'a'));
                    arr[i]--;
                }
            }
            for (int i = 25; i >= 0; i--){
                if (arr[i] > 0){
                    sb.append((char)(i + 'a'));
                }
            }

        }
        return sb.toString();
    }
    boolean haveChar(int[] arr) {
        for (int i = 0; i < 26; ++i) {
            if (arr[i] != 0) {
                return true;
            }
        }
        return false;
    }
}
