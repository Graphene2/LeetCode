package 哈希表.time_8_29;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/29,10:40
 * @version: 1.0
 */
public class lc645错误的集合 {
    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = 1;
        for (int n: nums) {
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{dup, missing};
    }
}
