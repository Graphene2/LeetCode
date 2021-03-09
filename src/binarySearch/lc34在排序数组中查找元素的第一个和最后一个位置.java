package binarySearch;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-15
 * Time: 19:43
 */
public class lc34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target){
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        // 先找左边的位置
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (target > nums[mid]){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        int left = l;
        if (nums[l] != target) return new int[]{-1, -1};
        l = 0; r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2 + 1;   // 中位数取右边
            if (target >= nums[mid]){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        int right = l;
        if (nums[l] != target) return new int[]{-1,-1};

        return new int[]{left,right};
    }
}
