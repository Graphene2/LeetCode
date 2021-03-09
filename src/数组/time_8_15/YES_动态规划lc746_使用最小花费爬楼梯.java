package 数组.time_8_15;

/**leetcode746: 使用最小花费爬楼梯
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,21:16
 * @version: 1.0
 */
public class YES_动态规划lc746_使用最小花费爬楼梯 {
    public static int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = 0; i < cost.length; i++) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }


    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int m = minCostClimbingStairs(cost);
        System.out.println(m);
    }
}
