package DEC;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/12/29,10:03
 * @version: 1.0
 */
public class lc330按要求补齐数组 {
    public int minPatches(int[] nums, int n) {
        int i = 0, count = 0;
        long add = 1;
        while (add <= n){
            if (i < nums.length && nums[i] <= add) add += nums[i++];
            else {
                add += add;
                count++;
            }
        }
        return count;
    }
}
