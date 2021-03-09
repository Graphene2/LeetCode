package traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-20
 * Time: 16:07
 */
public class 面试08_12八皇后 {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(res,chess,0);
        return res;
    }

    private void solve(List<List<String>> res, char[][] chess, int row) {
        // 终止条件
        if (row == chess.length){
            res.add(construct(chess));
            return;
        }
        // 遍历每一列
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess,row,col)){
                char[][] temp = copy(chess);
                //在当前位置放个皇后
                temp[row][col] = 'Q';
                solve(res,temp,row +1);
            }
        }
    }

    private char[][] copy(char[][] chess) {
        char[][] temp = new char[chess.length][chess[0].length];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                temp[i][j] = chess[i][j];
            }
        }
        return temp;
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
        // 采用另一种方式判断左上角有没有皇后。
//        int i = row - 1, j = col - 1;
//        while (i >= 0 && j >= 0) {
//            if (chess[i][j] == 'Q') {
//                return false;
//            }
//            --i;
//            --j;
//        }
        // 采用另一种方式判断右上角有没有皇后。
//        i = row - 1;
//        j = col + 1;
//        while (row >= 0 && j < col) {
//            if (chess[i][j] == 'Q') {
//                return false;
//            }
//            --i;
//            ++j;
//        }

        return true;
    }

    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }

    // 下面为回溯算法
    public List<List<String>> solveNQueens2(int n){
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                chess[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        solve2(res, chess, 0);
        return res;

    }

    private void solve2(List<List<String>> res, char[][] chess, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess,row,col)){
                chess[row][col] = 'Q';
                solve2(res,chess,row + 1);
                chess[row][col] = '.';
            }
        }
    }

}
