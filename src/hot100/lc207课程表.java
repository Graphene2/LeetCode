package hot100;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**主要的知识点是图，有向图、无向图等
 * Description:
 * User: zhangcheng
 * Date: 2020-12-07
 * Time: 14:31-15:05
 */
public class lc207课程表 {
    // 方法一位拓扑排序，即广度优先算法，首先将入度为零的节点加入队列中，
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0){
            return false;
        }
        int len = prerequisites.length;
        if (len == 0){
            return true;
        }
        // 建立两个存储空间，一个为入度数组
        int[] inDegree = new int[numCourses];
        // 建立一个hashset数组保存入度的指向
        HashSet<Integer>[] Points = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            Points[i] = new HashSet<>();
        }
        // 遍历pre数组，将对应关系存入数组中。
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            Points[p[1]].add(p[0]);
        }
        // 采用一个队列存放入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            int top = queue.poll();
            count++;
            // 这里保证了入度大于1时只进行一次计算!
            for(int succeessor : Points[top]){
                inDegree[succeessor]--;
                if (inDegree[succeessor] == 0){
                    queue.add(succeessor);
                }
            }
        }
        return count == numCourses;
    }
}
