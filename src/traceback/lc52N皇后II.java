package traceback;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-20
 * Time: 19:33
 */
public class lc52N皇后II {
    int res;
    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                chess[i][j] = '.';
        res = 0;
        solve( chess, 0);
        return res;
    }
    private void solve( char[][] chess, int row) {
        if (row == chess.length) {
            res++;
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess,row,col)){
                chess[row][col] = 'Q';
                solve(chess,row + 1);
                chess[row][col] = '.';
            }
        }
    }
    private boolean valid(char[][] chess, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q'){
                return false;
            }
        }
        // 判断右上角有没有皇后
        for (int i = row - 1,j = col + 1; i >= 0 && j < chess.length; i--,j++) {
            if (chess[i][j] == 'Q'){
                return false;
            }
        }
        // 判断左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (chess[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        lc52N皇后II m = new lc52N皇后II();
        int n = m.totalNQueens(4);
        System.out.println(n);
    }
}
