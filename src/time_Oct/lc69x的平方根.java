package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-15
 * Time: 8:55
 */
public class lc69x的平方根 {
    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;
        while (left < right){
            // 这里是寻找小于目标值最大的情况，所以选取中间值偏右的值，同时r=mid - 1; l = mid;
            long mid = (left + right) / 2 + 1;
            //long mid = (left + right + 1) / 2;
            long sqrt = mid * mid;
            if (sqrt > x) right = mid - 1;
            else left = mid;
        }
        return (int)left;
    }

    // 牛顿迭代法
    public int mySqrt2(int x){
        if (x == 0) return 0;
        double c = x , x0 = x;
        while (true){
            double xi = 0.5 * (x0 + c / x0);
            if (Math.abs(xi - x0) < 1e-7)
                break;
            x0 = xi;
        }
        return (int)x0;
    }
}
