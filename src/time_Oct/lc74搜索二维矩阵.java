package time_Oct;

/**
 * Description:典型的二分法的应用。
 * User: zhangcheng
 * Date: 2020-10-15
 * Time: 15:25-15:41
 */
public class lc74搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (matrix == null || row == 0) return false;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left < right){
            int mid = (left + right) / 2;
            int elm = matrix[mid / col][mid % col];
            if (elm == target){
                return true;
            }else if (target > elm){
                left = mid + 1;
            }else right = mid;
        }
        return matrix[left / col][left % row] == target;
    }
    // 先用二分法找出在哪一列，再继续二分法寻找
    public boolean searchMatrix2(int[][] matrix, int target){
        int row = matrix.length, col = matrix[0].length;
        if (matrix == null || row == 0 || col == 0) return false;
        int i = ColBinarySearch(matrix, target);
        if (i >= matrix.length) return false;
        int j = RowBinarySearch(matrix,i,target);
        if (j >= col) return false;
        if(matrix[i][j] == target) return true;
        return false;
    }

    private int RowBinarySearch(int[][] matrix, int i, int target) {
        int l = 0, r = matrix[0].length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (matrix[i][mid] < target){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        if (matrix[i][l] <= target){
            return l;
        }
        return l - 1 >= 0 ? l - 1 : 0;
    }

    private int ColBinarySearch(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            int elem = matrix[mid][0];
            if (target <= elem){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if (matrix[l][0] <= target){
            return l;
        }
        return l - 1 >= 0 ? l - 1 : 0;
    }


}
