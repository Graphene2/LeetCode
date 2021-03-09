package 数组.time_8_20;

/**lc189旋转数组
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/20,23:06
 * @version: 1.0
 */
public class YES_lc189旋转数组 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

}
