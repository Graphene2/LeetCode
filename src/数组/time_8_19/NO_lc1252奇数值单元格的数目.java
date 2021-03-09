package 数组.time_8_19;

/**lc1252奇数值单元格的数目
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 15:57-16:07
 */
public class NO_lc1252奇数值单元格的数目 {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < indices.length; i++){
            row[indices[i][0]]++;
            col[indices[i][1]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                int temp = row[i] + col[j];
                if (temp % 2 == 1) ans++;
            }
        }return ans;

    }
}
