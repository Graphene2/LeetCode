package 数组.time_8_16;

/**leetcode849：到最近的人的最大距离
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/16,14:52
 * @version: 1.0
 */
public class NO_lc849_到最近的人的最大距离 {
    public int maxDistToClosest(int[] seats) {
        int max = 0, sum = 0;
        int j = 0;
        if (seats[0] == 0){
            while (seats[j] == 0){
                max++;
                j++;
            }
        }
        int m = seats.length - 1,max1 = 0;
        if (seats[seats.length - 1] == 0){
            while (seats[m] == 0){
                max1++;
                m--;
            }
            max = Math.max(max,max1);
        }
        for (int i = j; i <= m; ++i){
            if (seats[i] == 0){
                sum++;
                max = Math.max((sum + 1) / 2,max);
            }
            if (seats[i] == 1){
                sum = 0;
            }
        }
        return max;
    }
}
