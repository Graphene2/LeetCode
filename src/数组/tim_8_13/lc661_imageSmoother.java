package 数组.tim_8_13;

/**leetcode661: 照片平滑器：
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 20:19-20:41
 */
public class lc661_imageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                for (int ni = i - 1; ni <= i + 1; ni++) {
                    for (int nj = j - 1; nj <= j + 1; nj++) {
                        if (0 <= ni && ni < row && 0 <= nj && nj < col) {
                            res[i][j] += M[ni][nj];
                            count++;
                        }
                    }
                }
                res[i][j] /= count;
            }
        }
        return res;
    }

    // 设置不同的方向位
    public int[][] imageSmoother2(int[][] M) {
        if (M == null || M.length < 1 || M[0] == null || M[0].length < 1) {
            return null;
        }

        int row = M.length;
        int col = M[row - 1].length;

        int ans[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = calcul(M, i, j);
            }
        }

        return ans;
    }

    // 上、下、左、右，上左，上右，下左，下右
    int dirR[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    int dirC[] = {0, 0, -1, 1, -1, 1, -1, 1};

    private int calcul(int arr[][], int i, int j) {
        int count = 1;
        int sum = arr[i][j];
        int row = arr.length, col = arr[0].length;
        // 用一个数组遍历不同的方向位置。常规思路！
        for (int k = 0; k < dirR.length; k++) {
            int nextR = i + dirR[k];
            int nextC = j + dirC[k];

            if (nextR >= 0 && nextR < row && nextC >= 0 && nextC < col) {
                count++;
                sum += arr[nextR][nextC];
            }
        }

        return sum / count;
    }
}



