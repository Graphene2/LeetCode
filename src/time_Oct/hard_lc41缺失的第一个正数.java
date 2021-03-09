package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-27
 * Time: 20:06
 */
public class hard_lc41缺失的第一个正数 {
    // 类似于哈希表，通过原地数组进行标记
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n){
                nums[nums[i] - 1] = - Math.abs(nums[nums[i] - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
    // 原地置换
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
}
