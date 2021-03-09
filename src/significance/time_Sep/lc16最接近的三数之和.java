package significance.time_Sep;

import java.util.Arrays;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-23
 * Time: 14:21-14:57
 */
public class lc16最接近的三数之和 {
    public static int threeSumClosest(int[] nums, int target) {
        int m = nums.length;
        if (m == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int ans = 0,abs = Math.abs(target - nums[0] - nums [1] - nums[2]);
        for (int i = 0; i < m; i++){
            int left = i + 1, right = m - 1;
            while (left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target) return temp;
                if (abs >= Math.abs(temp - target)){
                    abs = Math.abs(temp - target);
                    ans = temp;
                }
                if (temp > target) right--;
                else left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }
}
