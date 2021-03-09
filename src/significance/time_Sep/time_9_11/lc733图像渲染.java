package significance.time_Sep.time_9_11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/11 9:19
 */
public class lc733图像渲染 {
    // 比较常规的DFS方法！
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor){
            helper(image,sr,sc,currColor,newColor);
        }
        return image;
    }

    private void helper(int[][] image, int x, int y, int color, int newColor) {
        if (image[x][y] == color){
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++){
                int mx = x + dx[i] , my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length){
                    helper(image,mx,my,color,newColor);
                }
            }
        }
    }
    // 自己做的DFS方法！
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        DFS(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }

    private void DFS(int[][] image, int sr, int sc, int newColor,int oldcolor) {
        if (sr < 0 || sr >= image.length || sc < 0
                || sc >= image[0].length ||  newColor == oldcolor || image[sr][sc] != oldcolor ) return;

        image[sr][sc] = newColor;
        DFS(image,sr - 1,sc, newColor,oldcolor);
        DFS(image,sr + 1,sc, newColor,oldcolor);
        DFS(image, sr , sc + 1 , newColor,oldcolor);
        DFS(image, sr ,sc + 1, newColor,oldcolor);
    }
    // 下面有请BFS方法
    public int[][] floodFill3(int[][] image, int sr, int sc, int newColor){
        int curColor = image[sr][sc];
        if (curColor == newColor) return image;
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<>() ;
        queue.add(new int[]{sr,sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++){
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == curColor){
                    queue.add(new int[]{mx,my});
                    image[mx][my] = newColor;
                }
            }
        }return image;
    }
}
