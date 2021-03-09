package 数组.time_8_15;

/**leetcode1450: 在既定时间做作业的学生人数 太简单了！
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,11:09
 * @version: 1.0
 */
public class NO_lc1450_在既定时间做作业的学生人数 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++){
            if (startTime[i] <= queryTime && queryTime <= endTime[i]){
                count++;
            }
        }
        return count;
    }
}
