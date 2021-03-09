package hot100;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-21
 * Time: 14:58
 */
public class lc238除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        if (nums == null || nums.length == 0){
            return ans;
        }
        // 第一遍遍历表示ans[i] 是nums[i] 左侧数字乘积
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = len - 1; i >= 0 ; i--) {
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }
        return ans;
    }
}
