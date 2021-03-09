package 数组.time_8_15;

import java.util.ArrayList;
import java.util.List;

/**leetcode1018 可被5整除的二进制前缀。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,10:22-10:50
 * @version: 1.0
 */
public class lc1018_可被5整除的二进制前缀 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        //余数定理a=b%c=b%c%c;（a+b）%c=((a%c)+(b%c))%c,ab%c=((a%c)*(b%c))%c;
        //所以要先对sum值取余
        List<Boolean> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = (sum * 2 + A[i]) % 5;
            if (sum == 0) list.add(true);
            else list.add(false);

        }
        return list;
    }
}
