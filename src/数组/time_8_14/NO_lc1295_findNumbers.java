package 数组.time_8_14;

/**leetcode1295: 统计位数为偶数的个数。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,20:00-20:09
 * @version: 1.0
 */
public class NO_lc1295_findNumbers {
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 9) continue;
            if (nums[i] < 99) count++;
            if (nums[i] < 999) continue;
            if (nums[i] < 9999) count++;
            if (nums[i] < 99999) continue;
            if (nums[i] == 100000) count++;
        }
        return count;
    }
    public static int findNumbers2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if ((int)(Math.log10((double) nums[i]) + 1) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,345,2,6,7896};
        int m = findNumbers2(arr);
        System.out.println(m);
    }
}
