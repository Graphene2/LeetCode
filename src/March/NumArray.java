package March;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-01
 * Time: 15:04
 */
public class NumArray {
    int[] sums;
    public  NumArray(int[] nums) {
        int n = nums.length;
        sums = new  int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
