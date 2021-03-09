package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-07
 * Time: 22:37
 */
public class lc48旋转图像 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先转置
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse
        for (int i = 0; i < n; i++){
            int m = 0, k = n - 1;
            while (m < k){
                int tmp = matrix[i][m];
                matrix[i][m] = matrix[i][k];
                matrix[i][k] = tmp;
                m++;
                k--;
            }
        }
    }
    public void rotate2(int[][] matrix){
        int add = 0, temp = 0, pos1 = 0;
        int pos2 = matrix[0].length - 1;
        while (pos1 < pos2){
            add = 0;
            while (add < pos2 - pos1) {
                temp = matrix[pos1][pos1 + add];
                matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1];
                matrix[pos2 - add][pos1] = matrix[pos2][pos2 - add];
                matrix[pos2][pos2 - add] = matrix[pos1 + add][pos2];
                matrix[pos1 + add][pos2] = temp;
                add++;
            }
            pos1++;
            pos2--;
        }
    }

}
