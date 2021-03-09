package 数组.time_8_12;

/**leetcode643: 子数组的最大平均数 滑动窗口的方法 Eazy
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/12,22:16
 * @version: 1.0
 */
public class lc643_findMaxAverage {
    public static double findMaxAverage(int[] nums, int k){
        int n = nums.length;
        int sum = 0,maxSum = 0;
        for (int j=0; j < k;j++){
            sum += nums[j];
        }
        maxSum = sum;
        for (int i = 0;i < n - k;i++){
            sum = sum - nums[i] + nums[i+k];
            maxSum = Math.max(sum, maxSum);
        }
        double result = (double) maxSum / k;
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,4,0,3,2};
        double m = findMaxAverage(arr,1);
        System.out.println(m);
    }
}
