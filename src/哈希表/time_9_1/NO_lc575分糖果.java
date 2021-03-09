package 哈希表.time_9_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/1 13:03
 */
class NO_lc575分糖果 {
    public int distributeCandies(int[] candies) {
        Set<Integer> seen = new HashSet<>();
        for (int e:candies){
            seen.add(e);
        }
        if (seen.size() >= candies.length / 2){
            return candies.length / 2;
        }else {
            return seen.size();
        }
    }

}
