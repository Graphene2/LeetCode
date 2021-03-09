package 数组.time_8_16;

/**leetcode509 斐波那契数 虽然也用了动态规划的思想，但是简答
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,14:45
 * @version: 1.0
 */
public class lc509_斐波那契数_动态规划简单 {
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int f0 = 0, f1 = 1;
        int sum = 0;
        for (int i = 2; i <= N; i++){
            sum = f0 + f1;
            f0 = f1;
            f1 = sum;
        }return sum;
    }
}
