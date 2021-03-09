package March;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-09
 * Time: 8:54
 */
public class lc1047_EAZY {
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        int len = S.length();
        if (len < 2){
            return S;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for (int i = 1; i < len; i++) {
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == chars[i]){
                sb.deleteCharAt(sb.length() - 1);
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
