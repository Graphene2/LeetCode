package 数组.time_8_16;

/**leetcode905: 按奇偶排序数组 原地算法
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,15:33
 * @version: 1.0
 */
public class lc905_按奇偶排序数组 {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j){
            if (A[i] % 2 != 0 && A[j] % 2 == 0){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;j--;
            }
            if (A[i] % 2 == 0 && A[j] % 2 == 0){
                i++;
            }
            if (A[i] % 2 == 0 && A[j] % 2 != 0){
                i++;j--;
            }
            if (A[i] % 2 != 0 && A[j] % 2 != 0){
                j--;
            }
        }return A;
    }
}
