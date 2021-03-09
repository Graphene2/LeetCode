package March;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-01
 * Time: 15:52
 */
public class lc896_EAZY {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        boolean ascend = false;
        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1]){
                continue;
            }else if (A[i] > A[i - 1]){
                ascend = true;
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (A[i] >= A[i - 1] && ascend){
                continue;
            }else if (A[i] <= A[i - 1] && !ascend){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
