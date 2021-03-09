package 数组.time_8_15;

import java.util.ArrayList;
import java.util.List;

/**leetcode1431: 拥有最多糖果的孩子 无用题目。没意义！！！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,15:47-15:53
 * @version: 1.0
 */
public class NO_lc1431_拥有最多糖果的孩子 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++){
            max = Math.max(candies[i], max);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++){
            if (candies[i] + extraCandies >= max) {
                res.add(true);
            }
            else {
                res.add(false);
            }
        }
        return res;
    }
}
