package 哈希表.time_8_28;

/**岛屿类题目，还可以用dfs算法实现！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,15:58
 * @version: 1.0
 */
public class YES_lc463岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    res += 4;
                    if (i > 0 && grid[i - 1][j] == 1) res -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) res -= 2;
                }

            }
        }
        return res;
    }
    // 采用dfs算法实现！
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int islandPerimeter2(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;

    }

    private int dfs(int[][] grid, int i, int j) {
        if (!isArea(i,j)) return 1;
        if (grid[i][j] == 0) return 1;
        if (grid[i][j] == 2) return 0;
        grid[i][j] = 2;
        int tmp = 0;
        for (int[] direction:directions){
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            tmp += dfs(grid,nextI,nextJ);
        }
        return tmp;
    }

    private boolean isArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
