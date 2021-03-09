package 数组.time_8_14;

import java.util.ArrayList;
import java.util.List;

/**leetcode119: 杨辉三角2
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,23:40
 * @version: 1.0
 */
public class YES_lc119_getRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++){
            res.add(1);
            for (int j = i - 1; j > 0; j--){
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
}
