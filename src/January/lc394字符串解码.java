package January;

import java.util.LinkedList;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-14
 * Time: 17:08
 */
public class lc394字符串解码 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stackMulti = new LinkedList<>();
        LinkedList<String> stackRes = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '['){
                stackMulti.addLast(multi);
                stackRes.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if (c == ']'){
                StringBuilder temp = new StringBuilder();
                int currMulti = stackMulti.removeLast();
                for (int i = 0; i < currMulti; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stackRes.removeLast() + temp);
            }else if (c >= '0' && c <= '9'){
                multi = multi * 10 + Integer.parseInt(c + "");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
