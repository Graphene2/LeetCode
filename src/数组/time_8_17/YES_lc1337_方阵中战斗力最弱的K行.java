package 数组.time_8_17;

import java.util.HashMap;
import java.util.Map;

/**leetcode1337: 方阵中战斗力最弱的 K 行
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,22:26
 * @version: 1.0
 */
public class YES_lc1337_方阵中战斗力最弱的K行 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++){
            map.put(numberSoldier(mat[i]) * 10 + i ,i);
        }
        return  ans;
    }
    private int numberSoldier(int[] arr){
        int high = arr.length - 1;
        int low = 0;
        while (low < high){
            int mid = (low + high) / 2 + 1;
            if (arr[mid] == 1){
                low = mid;
            }else high = mid - 1;
        }
        if (arr[high] == 1) return high + 1;
        else return 0;
    }
}
