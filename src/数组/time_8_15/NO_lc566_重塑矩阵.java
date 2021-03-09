package 数组.time_8_15;

/**lc566_重塑矩阵 ：简单题浪费了太多时间
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,15:59-16:28
 * @version: 1.0
 */
public class NO_lc566_重塑矩阵 {
    public  static int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] ans = new int[r][c];
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans[((n * i) + j) / c][((n * i) + j) % c] = nums[i][j];
            }
        }return ans;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] ans = matrixReshape(nums,4,3);
        for (int[] row:ans){
            for (int item:row){
                System.out.print(item+"\t");
            }
            System.out.println();
        }
    }
}
