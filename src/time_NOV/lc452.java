package time_NOV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-23
 * Time: 8:30-9:22
 */
public class lc452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> (a[0] == b[0] ? (a[1] > b[1] ? 1 : -1) : (a[0] > b[0] ? 1 : -1)));
        int len = points.length;
        LinkedList<int[]> temp = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            int left = points[i][0], right = points[i][1];
            if (temp.isEmpty() || temp.getLast()[1] < left){
                temp.add(new int[]{left,right});
            }else {
                temp.getLast()[1] = Math.min(temp.getLast()[1], right);
            }
        }
        return temp.size();
    }
}
