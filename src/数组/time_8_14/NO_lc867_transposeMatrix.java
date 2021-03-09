package 数组.time_8_14;

/**leetcode867: 转置矩阵 垃圾题目
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,17:52-17:56
 * @version: 1.0
 */
public class NO_lc867_transposeMatrix {
    public int[][] transpose(int[][] A){
        int row = A.length;
        int col = A[0].length;
        int[][] B = new int[col][row];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
