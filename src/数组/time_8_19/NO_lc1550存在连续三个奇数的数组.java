package 数组.time_8_19;

import java.util.HashSet;

/**leetcode1550:存在连续三个奇数的数组
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 10:54-11:09
 */
public class NO_lc1550存在连续三个奇数的数组 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++){
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0){
                return true;
            }
        }return false;
    }
}
