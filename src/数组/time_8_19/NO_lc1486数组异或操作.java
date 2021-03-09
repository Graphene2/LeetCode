package 数组.time_8_19;

/**leetcode1486数组异或操作
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 15:07
 */
public class NO_lc1486数组异或操作 {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n ; i++){
            ans ^= (start + 2 * i);
        }
        return ans;
    }
}
