package 数组.time_8_14;

/**leetcode766: 托普利茨矩阵 建立方向矩阵。 注意 重新建立方向坐标进行遍历对比。
 * 时间复杂度O(M*N)
 * 空间复杂度O(1)
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,16:45-17:18
 * @version: 1.0
 */
public class lc766_isToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null) return false;
        for (int i = 0; i < matrix.length; i++){
            int m = matrix[i][0];
            int j = 0;
            int n = i;
            while (n < matrix.length&& j < matrix[0].length){

                if (m != matrix[n][j]){
                    return false;
                }
                n += 1;
                j += 1;
            }
        }
        for (int j = 0; j < matrix[0].length; j++){
            int m = matrix[0][j];
            int i = 0;
            int n = j;
            while (i < matrix.length && n < matrix[0].length){
                if (m != matrix[i][n]){
                    return false;
                }
                i += 1;
                n += 1;
            }
        }
        return true;
    }
    // 直接检查左上角元素和当前元素是否相等即可。简单易通过
    public boolean isToeplitzMatrix1(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }


    public static void main(String[] args) {
        int[][] mm = new int[][]{{11, 74, 0, 93}, {40, 11, 74, 7}};
        boolean m = isToeplitzMatrix(mm);
        System.out.println(m);
    }
}
