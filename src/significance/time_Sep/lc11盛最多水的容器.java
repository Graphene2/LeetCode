package significance.time_Sep;

/**双指针
 * Description:
 * User: zhangcheng
 * Date: 2020-09-23
 * Time: 14:05
 */
public class lc11盛最多水的容器 {
    public int maxArea(int[] height) {
        int L = 0, R = height.length - 1;
        int ans = 0;
        while (L < R){
            int high = Math.min(height[L],height[R]);
            ans = Math.max(ans,(R - L + 1) * high );
            if (height[L] < height[R]){
                L++;
            }else R--;
        }
        return ans;
    }
}
