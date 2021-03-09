package time_Oct;

import java.util.LinkedList;

/**
 * Description:重点在于分情况讨论
 * User: zhangcheng
 * Date: 2020-10-14
 * Time: 14:44-15:31
 */
public class hard_lc57插入数组 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0],newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> ans = new LinkedList<>();
        // add all intervals starting before newInterval
        while (idx < n && newStart > intervals[idx][0]){
            ans.add(intervals[idx]);
            idx++;
        }
        // new
        int[] interval = new int[2];
        if (ans.isEmpty() || ans.getLast()[1] < newStart){
            ans.add(newInterval);
        }else {
            interval = ans.removeLast();
            interval[1] = Math.max(interval[1],newEnd);
            ans.add(interval);
        }
        // add new intervals, merged with newInterval if needed
        while (idx < n){
            interval = intervals[idx];
            idx++;
            int start = interval[0],end = interval[1];
            if (ans.getLast()[1] < start){
                ans.add(interval);
            }else {
                int[] temp = ans.removeLast();
                temp[1] = Math.max(temp[1],end);
                ans.add(temp);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
