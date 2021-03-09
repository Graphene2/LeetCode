package time_Oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-14
 * Time: 14:16-14:44
 */
public class lc56合并区间 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++){
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L,R});
            }else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1],R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
