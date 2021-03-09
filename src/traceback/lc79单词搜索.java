package traceback;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-21
 * Time: 16:17-16:46
 */
public class lc79单词搜索 {
    private boolean[][] marked;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int m;
    private int n;
    private String word;
    private char[][] board;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) return false;

        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;
        // used 中为 1 的数为已经用过了。采用dfs搜索。
        // 意思即是如果找到了，返回值为true，就直接停止搜索，直接返回true，但是如果逐个搜索一直到最后没找到，那就返回false。
        boolean res = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1){
            return board[i][j] == word.charAt(start);
        }
        // 匹配，往下深入！
        if (board[i][j] == word.charAt(start)){
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX,newY) && !marked[newX][newY]){
                    if (dfs(newX,newY,start + 1)){
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        // 该位置不匹配，返回false不继续寻找。
        return false;
    }

    private boolean inArea(int newX, int newY) {
        if (newX >= 0 && newX < m && newY >= 0 && newY < n){
            return true;
        }
        return false;
    }


}
