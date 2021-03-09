package significance.time_Sep;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/24,0:01
 * @version: 1.0
 */
public class lc36有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++){
            if (!DFS_col(board,i)) return false;
            if (!DFS_row(board,i)) return false;
            if (i == 0 || i == 3 || i == 6){
                if (!DFS_tri(board,0,i)) return false;
                if (!DFS_tri(board,3,i)) return false;
                if (!DFS_tri(board,6,i)) return false;
            }
        }
        return true;
    }

    private boolean DFS_tri(char[][] board, int i,int j) {
        Set<Character> seen = new HashSet<>();
        for (int m = i; m < i + 3; m++){
            for (int n = j; n < j + 3; n++){
                char c = board[m][n];
                if (Character.isDigit(c)){
                    if (seen.contains(c)){
                        return false;
                    }
                    seen.add(c);
                }
            }
        }
        return true;
    }

    private boolean DFS_row(char[][] board, int i) {
        Set<Character> seen = new HashSet<>();
        for (int j = 0; j < board.length; j++){
            char c = board[j][i];
            if (Character.isDigit(c)){
                if (seen.contains(c)){
                    return false;
                }
                seen.add(c);
            }
        }
        return true;
    }

    private boolean DFS_col(char[][] board, int i) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < board.length; j++){
            char c = board[i][j];
            if (Character.isDigit(c)){
                if (set.contains(c)){
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }
}
