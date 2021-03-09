package 哈希表.time_8_28;

/**岛屿面积问题，典型的dfs问题。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,16:25
 * @version: 1.0
 */
public class YES_lc695岛屿的最大面积 {
    int m, n;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//对应了上右下左四个方向
    public int maxAreaOfIsland(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int seg = dfs(grid,i,j);
                res = Math.max(seg,res);
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        // 在界外，返回0
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        // 碰到海洋(0) 或者已经走过的陆地(2),返回0；
        if (grid[i][j] == 0 || grid[i][j] == 2) return 0;
        // 碰到未走过的陆地，先将该陆地设置为2，然后继续bfs。
        grid[i][j] = 2;
        int tmp = 1;
        for (int[] direction: directions){
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            tmp += dfs(grid,nextI,nextJ);
        }
        return tmp;
    }
}
