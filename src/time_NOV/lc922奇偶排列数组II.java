package time_NOV;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-12
 * Time: 8:59-9:09
 */
public class lc922奇偶排列数组II {
    // 原始方法
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int p1 = 0, p2 = 0;
        while (p1 < len && p2 < len){
            while (p1 < len && (p1 % 2 == 0 || A[p1] % 2 != 0)){
                p1++;
            }
            while (p2 < len && (p2 % 2 != 0 || A[p2] % 2 == 0)){
                p2++;
            }
            if (p1 < len && p2 < len){
                swap(A,p1,p2);
            }
        }
        return A;
    }

    private void swap(int[] a, int p1, int p2) {
        int temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
    }
    // 可以将两个指针分别指向奇数和偶数项，然后查看奇数项和偶数项是否满足条件。每次加2
}
