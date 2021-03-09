package 数组.time_8_11;

/**
 * 剑指offer53题：寻找排序数组的缺失数字   碰到排序数组题目第一反应：二分法 or 双指针。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/10 10:58
 */
public class offer53_missingNumber {
    public static int missingNumber1(int[] nums){
        int i = 0;
        int j = nums.length - 1;
        while (i <= j){
            int m = (i + j) / 2;
            if (nums[m] == m){
                i = m + 1;
            }else {
                j = m - 1;
            }
        }
       return i;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{0,1,2,3,4,5,6,7,8,9,11};
        int m = missingNumber1(nums);
        System.out.println(m);
    }
}
