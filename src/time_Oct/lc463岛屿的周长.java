package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-30
 * Time: 9:06
 */
public class lc463岛屿的周长 {
    int[][] direction = new int[][]{{-1, 0},{0,1},{0,-1},{1,0}};
    int res = 0;
    public int islandPerimeter(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1){
                    dfs(grid,i,j);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (!inArea(x,y,grid) || grid[x][y] == 0){
            res++;
            return;
        }
        if (grid[x][y] == 2) return;
        if (inArea(x,y,grid) && grid[x][y] == 1){
            grid[x][y] = 2;
            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                dfs(grid,newX,newY);
            }
        }
    }

    private boolean inArea(int x, int y,int[][] grid) {
        if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length){
            return true;
        }
        return false;
    }

}
