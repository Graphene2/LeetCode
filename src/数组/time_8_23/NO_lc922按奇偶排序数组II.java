package 数组.time_8_23;

/**lc922按奇偶排序数组II  双指针
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/23,11:03-11:12
 * @version: 1.0
 */
public class NO_lc922按奇偶排序数组II {
    public int[] sortArrayByParityII(int[] A) {

        int i = 0, j = 1;
        while (i < A.length && j < A.length){
            if (A[i] % 2 != 0 && A[j] % 2 != 1){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i += 2;
                j += 2;
            }else if (A[i] % 2 != 0 && A[j] % 2 == 1){
                j += 2;
            }else if (A[i] % 2 == 0 && A[j] % 2 != 1){
                i += 2;
            }else {
                i += 2;
                j += 2;
            }
        }
        return A;
    }
}
