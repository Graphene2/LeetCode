package time_Oct;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-14
 * Time: 15:30-15:51
 */
public class lc59螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if (n == 0) return ans;
        int left = 0, right = n - 1, top = 0, down = n - 1;
        int i = 1;
        while (i <= n * n){
            int col = left;
            while (i <= n * n && col <= right){
                ans[top][col] = i;
                col++;
                i++;
            }
            int row = top + 1;
            while (i <= n * n && row <= right){
                ans[row][right] = i;
                row++;
                i++;
            }
            col = right - 1;
            while (i <= n * n && col >= left){
                ans[down][col] = i;
                col--;
                i++;
            }
            row = down - 1;
            while (i <= n * n && row > top){
                ans[row][left] = i;
                row--;
                i++;
            }
            left++;right--;
            top++;down--;
        }
        return ans;
    }
    // 简化版
    public int[][] generateMatrix2(int n){
        int[][] ans = new int[n][n];
        if (n == 0) return ans;
        int l = 0, r = n - 1,t = 0, b = n - 1;
        int num = 1, tar = n * n;
        while (num <= tar){
            for (int i = l; i <= r; i++) ans[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) ans[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) ans[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) ans[i][l] = num++;
            l++;
        }
        return ans;
    }

}
