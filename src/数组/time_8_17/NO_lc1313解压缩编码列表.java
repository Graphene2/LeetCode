package 数组.time_8_17;

/**leetcode1313: 解压缩编码列表
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,22:12
 * @version: 1.0
 */
public class NO_lc1313解压缩编码列表 {
    public int[] decompressRLElist(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2){
            sum += nums[i];
        }
        int[] ans = new int[sum];
        int j = 0;
        for (int i = 0; i < nums.length; i += 2){
            while (nums[i] > 0){
                ans[j] = nums[i + 1];
                j++;
                nums[i]--;
            }
        }
        return ans;
    }
}
