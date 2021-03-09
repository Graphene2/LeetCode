package 数组.time_8_14;

/**leetcode1304: 和为零的N个唯一整数
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,15:30-15:34
 * @version: 1.0
 */
public class NO_lc1304_sumZero {
    public static int[] sumZero(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n / 2; i++) {
            arr[i] = i + 1;
            arr[n - i - 1] = -arr[i];
        }
        return arr;
    }
}
