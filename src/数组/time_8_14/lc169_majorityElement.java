package 数组.time_8_14;

/**leetcode169: 多数元素 众数：摩尔投票法
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,15:15-15:26
 * @version: 1.0
 */
public class lc169_majorityElement {
    public static int majorityElement(int[] nums){
        int res = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (res == nums[i]){
                count++;
            }else {
                count--;
            }
            if (count == 0){
                res = nums[i];
                count = 1;
            }
        }
        int verify = 0;
        for (int item: nums){
            if (res == item){
                verify++;
            }
        }
        if (verify > nums.length / 2){
            return res;
        }else throw new RuntimeException("没有多数元素");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,1,1,2,2};
        int m = majorityElement(arr);
        System.out.println(m);
    }
}
