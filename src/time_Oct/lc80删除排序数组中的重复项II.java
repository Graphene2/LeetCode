package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-28
 * Time: 21:13
 */
public class lc80删除排序数组中的重复项II {
    public int[] remElement(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        return arr;
    }
    public int removeDuplicates(int[] nums) {
        int i = 1, count = 1, length = nums.length;
        while (i < length) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    this.remElement(nums, i);
                    i--;
                    length--;
                }
            }else {
                count = 1;
            }
            i++;
        }
        return length;
    }
    // 双指针
    public int removeDuplicates2(int[] nums) {
        if (nums == null) return 0;
        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]){
                count++;
            }else {
                count = 1;
            }
            if (count <= 2){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
