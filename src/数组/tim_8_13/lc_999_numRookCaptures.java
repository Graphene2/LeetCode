package 数组.tim_8_13;

/**
 * leetcode999: 可以被一步捕获的棋子。
 *
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 18:54-19:28
 */
public class lc_999_numRookCaptures {
    public int numRookCaptures(char[][] board) {
        //   // 定义方向数组，可以认为是四个方向向量，在棋盘问题上是常见的做法
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        // 先找出白车R的位置。
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    int res = 0;
                    for (int[] direction : directions) {
                        if (burnout(board, i, j, direction)) {
                            res++;
                        }
                    }return res;
                }
            }
        }



    return 0;
    }
    // 创建burnout，消灭一个 p，就返回 true
    private boolean burnout(char[][] board, int i, int j, int[] direction) {
        while (inArea(i,j)){
            if (board[i][j]=='B'){
                break;
            }
            if (board[i][j]=='p'){
                return true;
            }
            i += direction[0];
            j += direction[1];
        }
        return false;
    }
    // 是否在棋盘有效范围有效内
    private boolean inArea(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

}
