package time_NOV;

import time_Oct.KMP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-11-09
 * Time: 11:29-13:26
 */
public class lc973最接近原点的K个点 {
    // 采用优先队列进行采取K个点，然后输出。 如果想要从小到大排序，一定要是 重写(a,b)->(a-b);或者 return i.compareTo(b);

    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] obj1, int[] obj2) {
                int squa1 = obj1[0] * obj1[0] + obj1[1] * obj1[0];
                int squa2 = obj2[0] * obj2[0] + obj2[1] * obj2[0];
                return squa1 - squa2;
            }
        });
        int len = points.length;
        if (len <= K) return points;
        for (int i = 0; i < len; i++) {
            if (que.size() <= K){
                que.add(points[i]);
            }
            if (que.size() > K){
                que.poll();
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = que.poll();
        }
        return res;
    }
    // 采用快排的方法
    public int[][] kClosest2(int[][] points, int K) {
        if (points == null || K <= 0 || points.length < K){
            return new int[0][0];
        }
        int len = points.length;
        int left = 0;
        int right = len - 1;
        int cur = -1;
        // 对points 进行快排！
        while (cur != K - 1){
            cur = patiton(points,left,right);
            if (cur < K - 1){
                left = cur + 1;
            }
            if (cur > K - 1){
                right = cur - 1;
            }
        }
        return Arrays.copyOf(points,K);
    }

    private static int patiton(int[][] points, int left, int right) {
        int temp = left;
        int leftVal = points[left][0] * points[left][0] + points[left][1] * points[left][1];
        while (left < right){
            while (left < right &&
                    (points[right][0] * points[right][0] + points[right][1] * points[right][1]) >= leftVal){
                right--;
            }

            while (left < right &&
                    (points[right][0] * points[right][0] + points[right][1] * points[right][1]) <= leftVal){
                left++;
            }
            if (left < right){
                swapPoint(points,left,right);
            }
        }
        swapPoint(points,left, temp);
        return left;
    }

    private static void swapPoint(int[][] points, int left, int right) {
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }


}
