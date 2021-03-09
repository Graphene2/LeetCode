package significance.time_Sep;

import java.util.Arrays;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-23
 * Time: 20:28
 */
public class lc31下一个排列 {
    public void nextPermutation(int[] nums){
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }
        if (i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i ,j);
        }
        // 逆序是为了将j到end降序排列变为升序。
        reverse(nums,i + 1,nums.length - 1);
    }

    private void reverse(int[] nums, int L, int R) {
        while (L < R){
            swap(nums,L,R);
            L++;R--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
