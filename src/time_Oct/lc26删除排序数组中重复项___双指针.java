package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 16:42
 */
public class lc26删除排序数组中重复项___双指针 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
