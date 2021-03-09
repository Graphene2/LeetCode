package 数组.time_8_22;

/**剑指offer04二维数组的查找
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/22,8:38
 * @version: 1.0
 */
public class 剑指offer04二维数组的查找 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0;
        while (matrix[i][0] < target && i < m){
            int j = 0;
            while (matrix[i][j] <= target && j < n){
                if (matrix[i][j] == target){
                    return true;
                }else {
                j++;}
            }
            i++;
        }return false;
    }
    //  线性时间复杂度的解法
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;

        while (row < m && col >= 0){
            int num = matrix[row][col];
           if (num == target){
               return true;
           }else if (num > target){
               col--;
           }else {
               row++;
           }
        }return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean m = findNumberIn2DArray(arr , 5);
        System.out.println(m);
    }
}
