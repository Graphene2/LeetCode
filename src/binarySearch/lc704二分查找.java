package binarySearch;

/**
 * Description:二分查找最基础问题
 * User: zhangcheng
 * Date: 2020-10-15
 * Time: 19:36
 */
public class lc704二分查找 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (l + r ) / 2;
            if (target > nums[mid]){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
