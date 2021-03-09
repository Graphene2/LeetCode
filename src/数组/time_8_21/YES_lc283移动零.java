package 数组.time_8_21;

/**lc283移动零  双指针无疑
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/21 10:20
 */
public class YES_lc283移动零 {
    public static void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums == null) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0) {
                while (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{};
    }
}
