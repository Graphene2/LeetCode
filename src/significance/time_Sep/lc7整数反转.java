package significance.time_Sep;


/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-21
 * Time: 9:38-10:05
 */

public class lc7整数反转 {
    int reverse(int x) {
        if (x == 0) return 0;
        int ans = 0;
        while (x != 0){
            int pop = x % 10;
            x = x / 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7) )
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
        }
        return ans;
    }
}
