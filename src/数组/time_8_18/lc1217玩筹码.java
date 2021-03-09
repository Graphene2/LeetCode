package 数组.time_8_18;

/**leetcode1217: 玩筹码
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/18 18:01-18:04
 */
public class lc1217玩筹码 {
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++){
            if (position[i] % 2 == 0){
                even++;
            }else {
                odd++;
            }
        }return Math.min(odd, even);
    }
}
