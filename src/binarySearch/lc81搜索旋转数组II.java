package binarySearch;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-15
 * Time: 20:41-20:55
 */
public class lc81搜索旋转数组II {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[l] == nums[mid]){
                l++;
                continue;
            }
            if (nums[0] < nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[nums.length - 1]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
