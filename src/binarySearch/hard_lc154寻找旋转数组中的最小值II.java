package binarySearch;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-15
 * Time: 21:42
 */
public class hard_lc154寻找旋转数组中的最小值II {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]){
                l = mid + 1;
            }else if (nums[mid] < nums[r]){
                r = mid;
            }else {
                r--;
            }
        }
        return nums[l];
    }
}
