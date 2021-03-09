package significance.time_Sep.time_9_11;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 14:53
 */
public class lc200岛屿的数量 {
    int[] dx = {0 ,0 , -1, 1};
    int[] dy = {1 , -1, 0 ,0};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1') {
                    DFS(grid,i,j);
                    count++;
                }
            }
        }return count;
    }

    private void DFS(char[][] grid, int x, int y) {
        if (grid[x][y] == '1'){
            for (int i = 0; i < 4; i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && mx < grid.length && my >= 0 && my < grid[0].length && grid[mx][my] == '1'){
                    DFS(grid,mx,my);
                }
            }
            grid[x][y] = '2';
        }
    }

    public static void main(String[] args) {
    }
}
