package JAVAFORMEETING;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-04-14
 * Time: 20:00
 */
public class lc45跳跃游戏II {
    public int jump(int[] nums){
        int maxPosition = 0;
        int len = nums.length;
        int steps = 0;
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
