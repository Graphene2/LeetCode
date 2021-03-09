package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-08
 * Time: 16:58
 */
public class lc27移除元素___双指针 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int fast = 0, slow = 0;
        while (fast < nums.length){
           if (nums[fast] != val ){
               if (fast != slow) {
                   nums[slow] = nums[fast];
               }
               slow++;
           }
           fast++;
        }
        return slow;
    }
}
