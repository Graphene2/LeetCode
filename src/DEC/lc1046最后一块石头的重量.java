package DEC;

import java.util.PriorityQueue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-30
 * Time: 9:09
 */
public class lc1046最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        for (int stone : stones){
            pq.offer(stone);
        }
        while (pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if (a > b){
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
