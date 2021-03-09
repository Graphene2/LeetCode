package 数组.time_8_19;

/**面试10_01:合并的排序数组
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 16:42
 */
public class 面试10_01合并的排序数组 {
    public void merge(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        while (pa >= 0 || pb >= 0 ){
            if (pa == -1){
                A[tail] = B[pb];
                pb--;
                tail--;
            }else if (pb == -1){
                A[tail] = A[pa];
                tail--;
                pa--;
            }else if (A[pa] >= B[pb]){
                A[tail] = A[pa];
                tail--;
                pa--;
            }else {
                A[tail] = B[pb];
                pb--;
                tail--;
            }
        }
    }
}
