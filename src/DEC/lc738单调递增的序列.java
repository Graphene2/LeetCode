package DEC;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-15
 * Time: 14:23
 */
public class lc738单调递增的序列 {
    // 贪心算法！
    public int monotoneIncreasingDigits2(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int flag = strN.length;
        for (int i = strN.length - 1; i > 0; i--) {
            if (strN[i - 1] > strN[i]){
                flag = i;
                strN[i - 1]--;
            }
        }
        for (int j = flag; j < strN.length; j++) {
            strN[j] = '9';
        }
        return Integer.parseInt(new String(strN));
    }
    // 巧妙地数学方案。。吐了
    public int monotoneIncreasingDigits(int N) {
        int result = 0;
        int ones = 111111111;
        for (int i = 0; i < 9; i++) {
            while (result + ones > N){
                ones /= 10;
            }
            result += ones;
        }
        return result;
    }
}
