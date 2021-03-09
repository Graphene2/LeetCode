package time_Oct;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-15
 * Time: 14:15-14:55
 */
public class lc73矩阵置零 {
    // 时间复杂度为 M*N， 空间复杂度为M+N
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row.contains(i) || col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    // 优化空间复杂度，将每一行是否置零标记到第一个位置。
    public void setZeroes2(int[][] matrix){
        // m为行，n为列,matrix[0][0] 判断第一行是否置零，而isRow信号判断第一列是否置零。
        int row = matrix.length, col = matrix[0].length;
        boolean isRow = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0){
                isRow = true;
            }
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0){
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isRow){
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
