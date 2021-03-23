package March;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-15
 * Time: 9:18
 */
public class lc54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        int top = 0, down = row - 1, left = 0, right = col - 1;
        while (left <= right && top <= down){
            for (int i = left; i <= right ; i++) {
                res.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (left < right && top < down) {
                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[down][i]);
                }

                for (int i = down; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            top++;
            down--;
            right--;
            left++;
        }
        return res;
    }
}
