package time_NOV;

import org.w3c.dom.ls.LSInput;

import java.util.*;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-17
 * Time: 9:09
 */
public class lc1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int t = i * C + j;
                res[t][0] = i;
                res[t][1] = j;
            }
        }
        Arrays.sort(res,(arr1,arr2)->{
            int dist1 = dist(arr1[0],arr1[1],r0,c0);
            int dist2 = dist(arr2[0],arr2[1],r0,c0);
            return Integer.compare(dist1,dist2);
        });
        return res;
    }

    private int dist(int x, int y, int r0, int c0) {
        return Math.abs(x - r0) + Math.abs(y - c0);
    }
    // 桶排序
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        ArrayList<LinkedList<int[]>> bucket = new ArrayList<>(maxDist + 1);
        for (int i = 0; i <= maxDist ; i++) {
            bucket.add(new LinkedList<>());
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i,j,r0,c0);
                LinkedList list = bucket.get(d);
                list.add(new int[]{i,j});
            }
        }
        int cnt = 0;
        for (int i = 0; i <= maxDist ; i++) {
            LinkedList<int[]> arr = bucket.get(i);
            if (arr.isEmpty())
                continue;
            for (int[] p : arr){
                res[cnt][0] = p[0];
                res[cnt][1] = p[1];
                cnt++;
            }
        }
        return res;
    }


}
