package 哈希表.time_8_28;

import java.util.HashSet;

/**首选位运算！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,16:43
 * @version: 1.0
 */
public class NO_lc136只出现一次的数字 {
    // 通过位运算进行查询！
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            ans ^= nums[i] ^ 0;
        }
        return ans;
    }

}
