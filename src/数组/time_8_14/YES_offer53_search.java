package 数组.time_8_14;

/**剑指offer53： 在排序数组中出现的次数。 肯定为二分法
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,20:55
 * @version: 1.0
 */
public class YES_offer53_search {
    public static int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int mid = (i + j) / 2;
            if (nums[mid] <= target){
                i = mid + 1;
            }else j = mid - 1;
        }
        int right = i;
        i = 0;
        j = nums.length - 1;
        while (i <= j){
            int mid = (i + j) / 2;
            if (nums[mid] < target){
                i = mid + 1;
            }else j = mid - 1;
        }
        int left = j;
        return right - left - 1;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{5,7,7,8,8,10};
        int m = search(arr,8);
        System.out.println(m);
    }

}
