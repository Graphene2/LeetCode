package 数组.time_8_11;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/11 10:11
 */
public class lc26_removeDuplicates {
    public static int removeDuplicates(int[] nums){
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if (nums[i] != nums[j]){
                if (j - i > 1){
                nums[i+1] = nums[j];}
                i++;
            }
        }return i + 1;
    }
}
