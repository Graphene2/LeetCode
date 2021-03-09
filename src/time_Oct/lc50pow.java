package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-14
 * Time: 10:08
 */
public class lc50pow {
    public double quickMul(double x, long N){
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0? y * y : y * y * x;
    }
    public double myPow(double x, int n){
            long N = n;
            return N >= 0 ? quickMul(x,N): 1.0 / quickMul(x, -N);
    }

    double quickMul2(double x, long N){
        double ans = 1.0;
        double x_contri = x;
        while (N > 0){
            if (N % 2 == 1){
                ans *= x_contri;
            }
            x_contri *= x_contri;
            N = N >> 1;
        }
        return ans;
    }
}
