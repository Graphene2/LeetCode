package 数组.tim_8_13;

/**leetcode1232: 缀点成线。 不要用斜率的方法，这样会漏掉边界条件，应该采用乘积的方法进行。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 16:16-16:
 */
public class lc1232_checkStraightLine {
    public static boolean checkStraightLine(int[][] coordinates){
        if (coordinates.length == 0 || coordinates.length == 1) return false;
        if (coordinates.length == 2) return true;
        int x1 =coordinates[1][0]-coordinates[0][0];
        int y1 =coordinates[1][1]-coordinates[0][1];
        for (int i = 2 ; i < coordinates.length; i++){
            int x2 = coordinates[i][0]-coordinates[0][0];
            int y2 =coordinates[i][1]-coordinates[0][1];
            if (x1 * y2 != x2 * y1) {
                return false;
            }
        }return true;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 0}, {0, 1}, {0, -1}};
        boolean m = checkStraightLine(arr);
        System.out.println(m);
    }
}
