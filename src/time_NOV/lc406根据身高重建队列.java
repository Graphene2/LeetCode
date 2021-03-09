package time_NOV;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-16
 * Time: 9:43-10:04
 */
public class lc406根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
        List<int[]> res = new LinkedList<>();
        for (int[] person: people) {
            res.add(person[1],person);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
