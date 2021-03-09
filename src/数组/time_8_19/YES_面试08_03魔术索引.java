package 数组.time_8_19;

/**面试08_03魔术索引 采用二分剪枝的方法!
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 17:17
 */
public class YES_面试08_03魔术索引 {
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0 , nums.length - 1);
    }

    private int getAnswer(int[] nums, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1){
            return leftAnswer;
        }else if (nums[mid] == mid){
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }
}
