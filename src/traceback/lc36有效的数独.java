package traceback;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-22
 * Time: 21:02
 */
public class lc36有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9]; //行的位运算数组
        int[] cols = new int[9]; //列的位运算数组
        int[] boxes = new int[9]; //方格的位运算数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                int tmp = board[i][j] - '0';
                int boxIndex = i / 3 * 3 + j / 3;
                if ((rows[i] >> tmp & 1) == 1
                        || (cols[j] >> tmp & 1) == 1
                        || (boxes[boxIndex] >> tmp & 1)== 1){
                    return false;
                }
                rows[i] = rows[i] | (1 << tmp);
                cols[j] = cols[j] | (1 << tmp);
                boxes[boxIndex] = boxes[boxIndex] | (1 << tmp);
            }
        }
        return true;
    }
}
