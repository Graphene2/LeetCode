package 数组.time_8_16;

import java.util.Enumeration;

/**leetcode1013:  将数组分成和相等的三个部分 双指针方法更简便！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,21:47
 * @version: 1.0
 */
public class NO_lc1013将数组分成和相等的三个部分 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++){
            sum += A[i];
        }
        int first = 0;
        int sum2 = 0, sum1 = 0;
        for (int i = 0; i < A.length; i++){
            sum1 += A[i];
            if (sum1 == sum / 3){
                first = i;
                break;
            }
        }
        int second = 0;
        for (int i = A.length - 1; i >= 0; i--){
            sum2 += A[i];
            if (sum2 == sum / 3){
                second = i;
                break;
            }
        }
        if (first >= second - 1) return false;
        int sum3 = 0;
        for (int i = first + 1; i < second; i++){
            sum3 += A[i];
        }
        if (sum3 != sum / 3)return false;
        return true;
    }
}
