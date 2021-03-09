package 数组.time_8_15;

import java.util.ArrayList;
import java.util.List;

/**leetcode1260： 二维网络迁移  题目不难，关键先弄清楚逻辑结构
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,15:15-15:46
 * @version: 1.0
 */
public class lc1260_二维网络迁移 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List res = new ArrayList<>();
        int m = grid.length;
        if (m == 0) return res;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[(i + (j + k) / n) % m][(j + k) % n] = grid[i][j];
            }
        }
        for (int[] row:ans){
            List<Integer> newRow = new ArrayList<>();
            for (int item:row){
                newRow.add(item);
            }
            res.add(newRow);
        }
        return res;
    }
}
