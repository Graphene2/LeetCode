package binarySearch;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-15
 * Time: 20:57
 */
public class lc153寻找旋转数组中的最小值 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            // on the right side of mid ascending , descending
            // mid 右边升序，直接看mid左边，考虑到只有两个元素的情况mid和r是分开的
            if (nums[mid] < nums[nums.length - 1]){
                r = mid;   // normally,when mid = （l + r) / 2 , we set r = mid, meanwhile  l = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
