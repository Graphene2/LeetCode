package hot100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-07
 * Time: 15:17
 */
public class lc210课程表II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
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
        int[] res = new int[numCourses];
        while (!queue.isEmpty()){
            int top = queue.poll();
            res[count] = top;
            count++;
            // 这里保证了入度大于1时只进行一次计算!
            for(int succeessor : Points[top]){
                inDegree[succeessor]--;
                if (inDegree[succeessor] == 0){
                    queue.add(succeessor);
                }
            }
        }
        if (count == numCourses){
            return res;
        }else {
            return new int[0];
        }
    }
}
