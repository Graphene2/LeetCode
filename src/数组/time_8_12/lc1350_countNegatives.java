package 数组.time_8_12;

/**leetcode1351: 统计有序矩阵中的负数。
 * 遍历：时间复杂度O(mn),空间复杂度为O(1)
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/12 10:39
 */
public class lc1350_countNegatives {
    public static int countNegatives(int[][] grid){
        int m = grid.length ,n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m;i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] >= 0) count++;
                else break;
            }
            if (grid[i][0] < 0) break;
        }
        return m*n - count;
    }
    // 采用二分查找使时间复杂度为O(mlogn),空间复杂度为O(1)
    public static int countNegatives2(int[][] grid){
        int m = grid.length ,n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m;i++){
            int[] row = grid[i];
            if (row[n-1] > 0) continue;
            if (row[0] < 0){
                count += (m - i) * n;
                break;
            }
            int first = _binarySrearch(row);

        }
        return m*n - count;

    }
    private static int _binarySrearch(int[] row){
        int begin = 0, end = row.length;
        int mid = (begin + end) / 2;
        while (begin < end){
            if (row[begin] >= 0) begin = mid + 1;
            else {
                if (row[mid - 1] >= 0)return mid;
                end = mid;
            }
        }
        return begin;

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{4,3,2,-1},{3,2,1,-1},
                {1,1,-1,-2},{-1,-1,-2,-3}};
        int m =  countNegatives2(grid);
        System.out.println(m);

    }
}
