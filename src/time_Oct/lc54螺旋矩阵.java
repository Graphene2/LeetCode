package time_Oct;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-14
 * Time: 10:35-11:20
 */
public class lc54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return order;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int total = rows * cols;
        int row = 0, col = 0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[rows][cols];
        int directionIndex = 0;
        for (int i = 0; i < total; i++){
            order.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[directionIndex][0], nextCol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol] == true){
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return order;
    }
    public List<Integer> spiralOrder2(int[][] matrix){
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, down = rows - 1;
        while (left <= right && top <= down){
            for (int col = left; col <= right;col++){
                order.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= down; row++){
                order.add(matrix[row][right]);
            }
            if (left < right && top < down){
                for (int col = right - 1; col > left; col--){
                    order.add(matrix[down][col]);
                }
                for (int row = down; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            down--;
        }
        return order;
    }
}
