package significance.time_Sep;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-23
 * Time: 21:23
 */
public class lc34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        if (nums.length == 1 && target == nums[0]) return new int[]{0,0};
        // 寻找左边位置
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        if (nums[r] != target) return new int[]{-1,-1};
        int left = r;
        l = 0;
        r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2 + 1;
            if (nums[mid] <= target){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        int right = r;
        return new int[]{left, right};
    }
}
