package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-21
 * Time: 15:41
 */
public class offer13机器人的移动范围 {
    // 深度优先搜索
    public int movingCount(int m, int n, int k) {
        boolean[][] marked = new boolean[m][n];
        return dfs(0,0,m,n,k, marked);
    }

    private int dfs(int x,int y,int m, int n,int k,boolean[][] marked){
        if (!inArea(x,y,m,n) || marked[x][y] || !isChoosed(x,y,k)){
            return 0;
        }
        int count = 1;
        marked[x][y] = true;
        count += dfs(x - 1, y,m,n,k,marked);
        count += dfs(x + 1, y,m,n,k,marked);
        count += dfs(x, y - 1,m,n,k,marked);
        count += dfs(x , y + 1,m,n,k,marked);
        return count;
    }


    // 广度优先搜索其实是可以的
    public int movingCount2(int m, int n, int k) {
        if (k == 0){
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0,1};
        int[] dy = {1,0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0,0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; i++) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (inArea(tx,ty,m,n) && !vis[tx][ty] && isChoosed(tx,ty,k)){
                    queue.offer(new int[]{tx,ty});
                    vis[tx][ty] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
    private boolean inArea(int x,int y,int m, int n) {
        return (x >= 0 && x < m) && (y >= 0 && y < n);
    }

    private boolean isChoosed(int x, int y,int k){
        int tmp = 0;
        while (x != 0){
            tmp += x % 10;
            x /= 10;
        }
        while (y != 0){
            tmp += y % 10;
            y /= 10;
        }
        return k >= tmp;
    }
}
