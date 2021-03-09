package significance.time_Sep;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-23
 * Time: 18:59-19:30
 */
public class lc29两数相除 {
    public int divide(int dividend, int divisor) {
        boolean isPositive = (dividend ^ divisor) >= 0;
        if (dividend > 0 ){
            dividend = opposite(dividend);
        }
        if (divisor > 0){
            divisor = opposite(divisor);
        }
        int res = 0;
        while (dividend <= divisor){
            int temp = divisor;
            int count = -1;
            while (temp < 0 && dividend <= temp){
                dividend -= temp;
                res += count;
                count += count;
                temp += temp;
            }
        }
        if (res == Integer.MIN_VALUE){
            if (isPositive) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;

        }else {
            if (isPositive){
                return opposite(res);
            }else {
                return res;
            }
        }
    }
    private int opposite(int x) {
        return ~x + 1;
    }


    // 二分法的思想
    public int divide2(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean k = (dividend >0 && divisor > 0) || (dividend < 0 && divisor < 0);
        int result=0;
        dividend = dividend <= 0 ? dividend : -dividend;
        divisor = -Math.abs(divisor);
        while(dividend <= divisor) {
            int temp = divisor;
            int c = 1;
            while(dividend - temp <= temp) {
                temp = temp << 1;
                c = c << 1;
            }
            dividend -= temp;
            result += c;
        }
        return k ? result : -result;
    }

}
