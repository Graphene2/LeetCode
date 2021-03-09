package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-19
 * Time: 17:29
 */
public class lc75颜色分类 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int zero = 0;
        int two = len;
        int i = 0;
        while (i < two){
            if (nums[i] == 0){
                swap(nums,i,zero);
                zero++;
                i++;
            }else if (nums[i] == 1){
                i++;
            }else {
                two--;
                swap(nums,i,two);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
