package 数组.time_8_11;

/**leetcode   :搜索插入位置
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/10 20:23
 */
public class searchIndex {
    public static int serachIndex1(int[] nums, int target){
        for (int i = 0; i < nums.length; i++){
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
