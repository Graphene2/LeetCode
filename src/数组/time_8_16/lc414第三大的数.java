package 数组.time_8_16;

/**leetcode414 第三大的数
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,20:39
 * @version: 1.0
 */
public class lc414第三大的数 {
    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long third = Long.MIN_VALUE,second = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > first){
                third = second;
                second = first;
                first = nums[i];
            }else if (nums[i] == first){
                continue;
            }else if (nums[i] > second){
                third = second;
                second = nums[i];
            }else if (nums[i] == second){
                continue;
            }else if (nums[i] > third){
                third = nums[i];
            }else continue;
        }if (third == Long.MIN_VALUE){
            return (int)first;
        }
        return (int)third;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,3};
        int m = thirdMax(arr);
        System.out.println(m);
    }
}
