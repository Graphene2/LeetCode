package 字符串.time_8_26;

/**有多重情况需要考虑！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/26 12:54-13:13
 */
public class lc859亲密字符串 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int pos1 = -1, pos2 = -1, count = 0;
        if (A.equals(B)){
            int[] arr = new int[26];
            for (char aa:A.toCharArray()){
                arr[aa - 'a']++;
            }
            for (int c: arr){
                if (c > 1) return true;
            }
        }
        for (int i = 0; i < A.length();i++){
            if (A.charAt(i) != B.charAt(i)){
                if (pos1 == -1)
                    pos1 = i;
                else if (pos2 == -1)
                    pos2 = i;
                else
                    return false;
            }
        }
        if (pos2 != -1 && A.charAt(pos1) == B.charAt(pos2) && A.charAt(pos2) == B.charAt(pos1)){
            return true;
        }else return false;
    }
}
