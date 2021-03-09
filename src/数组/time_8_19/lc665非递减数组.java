package 数组.time_8_19;

/**lc665非递减数组
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 16:08
 */
public class lc665非递减数组 {
    public boolean checkPossibility(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] > nums[i + 1]){
                temp++;
                if (temp > 1) break;
                if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]){
                    nums[i + 1] = nums[i];
                }else{
                    nums[i] = nums[i + 1];
                }
            }

        }
        return temp <= 1;
    }
}
