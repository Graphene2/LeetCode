package March;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-02
 * Time: 15:23
 */
public class lc166_MED {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0){
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        if (numerator < 0 ^ denominator < 0){
            fraction.append("-");
        }
        // 转化为long避免溢出 被除数 和 除数
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend % divisor));
        long remainder = dividend / divisor;
        if (remainder == 0){
            return fraction.toString();
        }
        // 余数不为 0 就需要考虑小数点和小数点后面的数了
        fraction.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while (remainder != 0){
            if (map.containsKey(remainder)){
                fraction.insert(map.get(remainder),"(");
                fraction.append(")");
                break;
            }
            map.put(remainder,fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}
