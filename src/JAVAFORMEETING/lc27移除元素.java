package JAVAFORMEETING;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-04-19
 * Time: 8:56
 */
public class lc27移除元素 {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            if (nums[0] == val){
                return 0;
            }else{
                return 1;
            }
        }
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l < r){
            if (nums[l] == val){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            }else {
                l++;
            }
        }
        return r + 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        removeElement(nums,2);

    }
}
