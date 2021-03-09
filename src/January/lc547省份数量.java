package January;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 使用并查集
 * User: zhangcheng
 * Date: 2021-01-06
 * Time: 11:08
 */
public class lc547省份数量 {
    // 第一个方法：并查集，最常见，也最套路。
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.getCount();
    }

    private class UnionFind{
        // 连通分量个数
        private int count;
        // 存储一棵树！
        private int parent[];
        // 记录每棵树的节点数。
        private int size[];
        // 构造函数
        public  UnionFind(int n){
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return;
            }
            if (size[rootX] > size[rootY]){
                parent[rootY] = rootX;
                size[rootX] += size[rootX];
            }else {
                parent[rootX] = rootY;
                size[rootY] += rootX;
            }
            count--;
        }
        private int find(int x) {
            while (parent[x] != x){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean isConnected(int x, int y){
            int rootX = x;
            int rootY = y;
            return rootX == rootY;
        }

        public int getCount(){
            return count;
        }
    }
    // 第二种: DFS
    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0)
            {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0){




                visited[i] = 1;
                dfs(M,visited,j);
            }
        }
    }
    // 第三种 BFS
    public int findCircleNum3(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0){
                queue.add(i);
            }
            while (!queue.isEmpty()){
                int s = queue.remove();
                visited[s] = 1;
                for (int j = 0; j < M.length; j++) {
                    if (M[s][j] == 1 && visited[j] == 0){
                        queue.add(j);
                    }
                }
            }
            count++;
        }
        return count;
    }

}
