package 哈希表.time_8_28;

import java.util.HashSet;
import java.util.Set;

/**  代码很简单，但是思路并不是那么容易。 首先需要分析题意列出各种情况再来思考代码实现的问题。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,20:14-20:24
 * @version: 1.0
 */
public class YES_lc202快乐数 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    private int getNext(int n){
        int totalSum = 0;
        while (n > 0){
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
