package 数组.time_8_12;

/**leetcode1266： 访问所有的点的最小时间。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/12 10:14
 */
public class lc1266_minTimeToVisitAllPoint {
    public static int minTimeToVisitAllPoint(int[][] points){
        int count = 0;
        for (int i = 0 ; i < points.length - 1 ; i++){
            count += Math.max(Math.abs(points[i][0]-points[i+1][0])
                    ,Math.abs(points[i+1][1]-points[i+1][1]));
        }return count;
    }

    public static void main(String[] args) {
        int [][] arr=new int[][]{{4,5},{2,3},{1,6}};
        int m = minTimeToVisitAllPoint(arr);
        System.out.println(m);

    }
}
