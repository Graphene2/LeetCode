package time_Oct;

/**
 * Description:动态规划，状态表示为向左侧或者右侧可以拓展的人数
 * User: zhangcheng
 * Date: 2020-10-26
 * Time: 9:09-9:33
 */
public class lc845数组中最长山脉 {
    public int longestMountain(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0 ; i--) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] > 0 && right[i] > 0){
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
