package 数组.time_8_11;

/**leetcode674： 寻找最长有序子串
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/10 21:12
 */
public class lc674_findLengthOfLCIS {
    public static int fingLengthOfLCIS(int[] nums){
        int ans = 0,count = 0;
        for (int i = 0;i < nums.length; i++){
            if (i > 0 && nums[i-1] >= nums[i]){
                count = i;
            }
            ans = Math.max(ans, i - count + 1);
        }
        return ans;
    }

    public static int fingLengthOfLCIS2(int[] nums){
        if (nums.length == 1){
            return 1;
        }
        if (nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length - 1;
        int temp = 1;
        int ans = 1;
        for (int i = left; i < right; i++){
            if (nums[i] < nums[i+1]){
                temp++;
                ans = Math.max(ans, temp);
            }else {
                temp = 1;
            }

        }return ans;
    }
}
