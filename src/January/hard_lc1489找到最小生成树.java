package January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-21
 * Time: 9:31
 */
public class hard_lc1489找到最小生成树 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        UnionFind unionFind = new UnionFind(n);
        int value = 0;
        for (int i = 0; i < m; i++) {
            if (unionFind.union(newEdges[i][0],newEdges[i][1])){
                value += newEdges[i][2];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            // 判断是否是关键边。
            UnionFind uf = new UnionFind(n);
            int v = 0;
            for (int j = 0; j < m; j++)  {
                if (i != j && uf.union(newEdges[j][0],newEdges[j][1])){
                    v += newEdges[j][2];
                }
            }
            if (uf.setCount != 1 || (uf.setCount == 1 && v > value)){
                ans.get(0).add(newEdges[i][3]);
                continue;
            }

            // 判断是否是伪关键边。
            uf = new UnionFind(n);

            uf.union(newEdges[i][0], newEdges[i][1]);
            v = newEdges[i][2];
            for (int j = 0; j < m; j++) {
                if (i != j && uf.union(newEdges[j][0],newEdges[j][1])){
                    v += newEdges[j][2];
                }
            }
            if (v == value){
                ans.get(1).add(newEdges[i][3]);
            }
        }
        return ans;
    }


    private class UnionFind {
        private int[] parent;
        private int[] size;
        int n;

        int setCount;
        public UnionFind(int n){
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(size,1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty){
                return false;
            }
            if (size[rootx] < size[rooty]){
                int temp = rootx;
                rootx = rooty;
                rooty = temp;
            }
            parent[rooty] = rootx;
            size[rootx] += size[rooty];
            setCount--;
            return true;
        }

        public boolean connected(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            return rootx == rooty;
        }
    }
}
