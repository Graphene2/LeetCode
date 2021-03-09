package January;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-13
 * Time: 10:43
 */
public class lc240搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length){
            if (matrix[row][col] > target){
                row--;
            }else if (matrix[row][col] < target){
                col++;
            }else {
                return true;
            }
        }
        return false;
    }
}
