package 哈希表.time_8_31;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**  广度优先搜索BFS 为方法一，主要实现方式为Queue；  深度优先搜索是递归。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/31,8:43-9:20
 * @version: 1.0
 */
public class YES_lc841钥匙与房间 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] bl = new  boolean[n];
        Queue<Integer> que = new LinkedList<>();
        bl[0] = true;
        que.offer(0);
        while (!que.isEmpty()){
            int x = que.poll();
            // num用来记录我们访问的房间数目，后面的判断即可保证重复访问的问题。
            num++;
            for (int i:rooms.get(x)){
                // 如果该位置还没有被访问(即被开锁)，那么开锁置true，并将该位置中的值放入队列中。
                if (!bl[i]){
                    bl[i] = true;
                    que.offer(i);
                }
            }
        }return num == n;
    }
    // 方法二：采用DFS解决问题。 不断进行递归！
    boolean[] vis;
    int num ;
    public  boolean canVisitAllRooms2(List<List<Integer>> rooms){
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms,0);
        return num == n;
    }

    public  void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int i: rooms.get(x)){
            if (!vis[i]){
                dfs(rooms,i);
            }
        }
    }
}

