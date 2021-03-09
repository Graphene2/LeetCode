package 数组.time_8_20;

import java.util.ArrayList;
import java.util.List;

/**lc1539第K个缺失的正数
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/20 12:17
 */
public class lc1539第K个缺失的正数 {
    public static int findKthPositive(int[] arr, int k) {
        int  i = 0,n = arr.length;
        for (i = 0; i < n; i++) {
            if (arr[i] - i - 1 >= k){
                return k + i;
            }
        }return k + i ;
    }
    // 二分法
    public static int findKthPositive2(int[] arr, int k) {
        int  left = 0, right = arr.length, mid = 0;
        while (left < right){
            mid = (left + right) / 2;
            if (arr[mid] - mid >= k + 1){
                right = mid;
            }else {
                left = mid + 1;
            }
        }return k + left;
    }



    public static void main(String[] args) {
        int[] ans = new int[]{2, 3, 4, 7, 11};
        int m = findKthPositive(ans, 5);
        System.out.println(m);
        List aa = new ArrayList();
    }
}
