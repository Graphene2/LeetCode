package 数组.time_8_17;

/**leetcode896单调数列
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/17 12:48
 */
public class NO_lc896单调数列 {
    public boolean isMonotonic(int[] A) {
        if (A.length == 1) return true;
        boolean add = true;
        if (A[0] > A[A.length - 1]){
            add = false;
        }
        for ( int i = 1; i < A.length; i++){
            if (add == true){
                if (A[i - 1] > A[i]){
                    return false;
                }
            }else if (add == false){
                if (A[i - 1] < A[i]){
                    return false;
                }
            }
        }return true;
    }
}
