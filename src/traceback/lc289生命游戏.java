package traceback;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-22
 * Time: 14:33
 */
public class lc289生命游戏 {
    int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    int[][] board;
    public void gameOfLife(int[][] board) {
        this.board = board;
        int m = board.length, n = board[0].length;
        // map记录需要修改的坐标和修改后的状态
        Map<int[],Integer> map = new HashMap<>();
        // 遍历整个数组，判断每个细胞的下一次的状态。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                BFS(board,i,j,map);
            }
        }
        for (int[] a:map.keySet()){
            board[a[0]][a[1]] = map.get(a);
        }
    }

    private void BFS(int[][] board, int row, int col, Map<int[], Integer> map) {
        int countLive = 0;
        for (int j = 0; j < 8; j++) {
            int newX = row + direction[j][0];
            int newY = col + direction[j][1];
            if (inArea(newX,newY)){
                if (board[newX][newY] == 1){
                    countLive++;
                }
            }
        }
        if (board[row][col] == 0 && countLive == 3){
            map.put(new int[]{row,col},1);
        }
        if (board[row][col] == 1 && (countLive < 2 || countLive > 3)){
            map.put(new int[]{row,col},0);
        }
    }

    private boolean inArea(int newX, int newY) {
        if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
            return true;
        }
        return false;
    }
}
